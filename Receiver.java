import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Receiver {
    int[] bits, polarisations, key;

    public void readQubits(Qubit[] qubits) {
        Random rnd = new Random();
        bits = new int[qubits.length];
        polarisations = new int[qubits.length];

        for (int i = 0; i < qubits.length; i++) {
            polarisations[i] = rnd.nextInt(2);

            bits[i] = qubits[i].measure(polarisations[i]);
        }
    }

    public int[] matchQubits(int[] inputPolarisations) {
        List<Integer> keyList = new ArrayList<>();

        for (int i = 0; i < polarisations.length; i++) {
            if (inputPolarisations[i] == polarisations[i]) {
                keyList.add(bits[i]);
            }
        }

        // Converting list of Integers to int[]
        key = keyList.stream().mapToInt(i -> i).toArray();

        return key;
    }

    public int[] transmitPolarisations() {
        return polarisations;
    }
}
