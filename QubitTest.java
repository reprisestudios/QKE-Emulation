///Name: Ethyn Gillies
///ID: 1503149

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class QubitTest {

    @ParameterizedTest
    @MethodSource("Values")
    @DisplayName("Measure Test")
    public void measureTest(int value, int polarisation) {
        Qubit qubit = new Qubit(value, polarisation);

        // Result should match since polarisation matches
        int result = qubit.measure(polarisation);

        Assertions.assertEquals(result, value);
    }

    private static Stream<Arguments> Values() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(1, 1));
    }
}
