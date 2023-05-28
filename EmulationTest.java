import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class EmulationTest {

    @ParameterizedTest
    @ValueSource(ints = { 16, 256, 1024 })
    @DisplayName("Key Match Test")
    public void keyMatchTest(int streamLength) {
        // Creating transmitter and receiver
        Transmitter transmitter = new Transmitter();
        Receiver receiver = new Receiver();

        // Transmitter creating randomised qubits
        Qubit[] sentQubits = transmitter.randomiseQubits(streamLength);

        // Receiver measures qubits using random polarisations
        receiver.readQubits(sentQubits);

        // Both transmit and exchange polarisation types used
        int[] transmitterPolarisations = transmitter.transmitPolarisations();
        int[] receiverPolarisations = receiver.transmitPolarisations();

        // Both match polarisation types and thus decide on a secret key
        int[] transmitterKey = transmitter.matchQubits(receiverPolarisations);
        int[] receiverKey = receiver.matchQubits(transmitterPolarisations);

        Assertions.assertArrayEquals(transmitterKey, receiverKey);
    }

    @ParameterizedTest
    @DisplayName("Message Transmission Test")
    @MethodSource("Values")
    public void messageTransmissionTest(int[] key, String message) {
        Transmitter transmitter = new Transmitter();
        Receiver receiver = new Receiver();

        transmitter.setKey(key);
        receiver.setKey(key);

        byte[] encoded = transmitter.sendMessage(message);
        String result = receiver.receiveMessage(encoded);

        Assertions.assertTrue(message.equals(result));
    }

    private static Stream<Arguments> Values() {
        int[] key1 = new int[] {
                0, 1, 1, 1, 1, 0, 0, 1
        };

        int[] key2 = new int[] {
                1
        };

        int[] key3 = new int[] {
                1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0
        };

        return Stream.of(
                Arguments.of(key1, "Test message."),
                Arguments.of(key2, "Test message."),
                Arguments.of(key3, "Test message."),
                Arguments.of(key1, ""),
                Arguments.of(key2, ""),
                Arguments.of(key3, ""),
                Arguments.of(key1, "!@#$%"),
                Arguments.of(key2, "!@#$%"),
                Arguments.of(key3, "!@#$%"));
    }
}
