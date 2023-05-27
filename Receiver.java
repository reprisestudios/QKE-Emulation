///Name: Ethyn Gillies
///ID: 1503149

import java.util.Random;

public class Receiver extends Module {

    /**
     * Measures Qubits using random polarisations, storing random polarisations
     * used.
     * 
     * @param qubits The qubits to measure
     */
    public void readQubits(Qubit[] qubits) {
        Random rnd = new Random();
        bits = new int[qubits.length];
        polarisations = new int[qubits.length];

        for (int i = 0; i < qubits.length; i++) {
            polarisations[i] = rnd.nextInt(2);

            bits[i] = qubits[i].measure(polarisations[i]);
        }
    }
}
