///Name: Ethyn Gillies
///ID: 1503149

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class QKEEmulation {

    public static void main(String[] args) throws IOException {
        int streamLength = 0;

        if (args.length != 1) {
            System.out.println("Usage: java QKEEmulation <stream length>");
            return;
        }

        try {
            streamLength = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Usage: java QKEEmulation <stream length>");
            return;
        }

        if (streamLength <= 0) {
            System.out.println("Please provide a stream length larger than 0");
            return;
        }

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

        // Building string for both keys for displaying on console
        StringBuilder tBuilder = new StringBuilder(transmitterKey.length);
        for (int i : transmitterKey) {
            tBuilder.append(i);
        }

        StringBuilder rBuilder = new StringBuilder(receiverKey.length);
        for (int i : receiverKey) {
            rBuilder.append(i);
        }

        System.out.println("Transmitter key: " + tBuilder.toString());
        System.out.println("Reciever key: " + rBuilder.toString());

        System.out.println();

        // Reader for user input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please input a message for the transmitter to send: ");
        String message = reader.readLine();

        // Transmitter sending message
        byte[] tEncoded = transmitter.sendMessage(message);
        String tDecoded = receiver.receiveMessage(tEncoded);

        System.out.println("Encoded message: " + new String(tEncoded, StandardCharsets.UTF_8));
        System.out.println("Decoded message by reciever: " + tDecoded);
        System.out.println();

        System.out.print("Please input a message for the reciever to send: ");
        message = reader.readLine();

        // Receiver sending message
        byte[] rEncoded = receiver.sendMessage(message);
        String rDecoded = transmitter.receiveMessage(rEncoded);

        System.out.println("Encoded message: " + new String(rEncoded, StandardCharsets.UTF_8));
        System.out.println("Decoded message by transmitter: " + rDecoded);
    }
}
