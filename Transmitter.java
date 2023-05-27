import java.util.Random;

public class Transmitter {
    int[] bits, polarisations;

    public Qubit[] randomiseQubits(int streamLength) {
        Qubit[] qubits = new Qubit[streamLength];
        bits = new int[streamLength];
        polarisations = new int[streamLength];

        for (int i = 0; i < streamLength; i++) {
            Qubit qubit = new Qubit();
            Random rnd = new Random();

            int value = rnd.nextInt(1);
            int polarisation = rnd.nextInt(1);

            qubit.newQubit(value, polarisation);

            qubits[i] = qubit;
            bits[i] = value;
            polarisations[i] = polarisation;
        }

        return qubits;
    }
}
