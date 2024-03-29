///Name: Ethyn Gillies
///ID: 1503149

import java.util.Random;

public class Transmitter extends Module {
    /**
     * Creates random qubits and stores their bit values and polarisations
     * 
     * @param streamLength The amount of qubits to create
     * @return An array of qubits that were created
     */
    public Qubit[] randomiseQubits(int streamLength) {
        // Instantiating vars
        Qubit[] qubits = new Qubit[streamLength];
        bits = new int[streamLength];
        polarisations = new int[streamLength];

        // For each qubit based on the specified stream length
        for (int i = 0; i < streamLength; i++) {

            Random rnd = new Random();

            int value = rnd.nextInt(2);
            int polarisation = rnd.nextInt(2);

            Qubit qubit = new Qubit(value, polarisation);

            // Store values for checking later
            qubits[i] = qubit;
            bits[i] = value;
            polarisations[i] = polarisation;
        }

        return qubits;
    }
}
