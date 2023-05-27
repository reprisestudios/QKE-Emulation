import java.util.Random;

public class Receiver {
    int[] bits, polarisations;

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
