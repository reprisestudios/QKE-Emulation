///Name: Ethyn Gillies
///ID: 1503149

import java.util.ArrayList;
import java.util.List;

public class Module {
    int[] bits, polarisations, key;

    /**
     * Sends a message in bytes, encoding using a XOR cipher with the key specified.
     * 
     * @param message The message to encode
     * @return The encoded message
     */
    public byte[] sendMessage(String message) {
        return XOR.encode(key, message);
    }

    /**
     * Decodes a message from bytes to String using the key specified
     * 
     * @param message The encoded message to decode
     * @return The decoded string
     */
    public String receiveMessage(byte[] message) {
        return XOR.decode(key, message);
    }

    /**
     * Finds the key to be used for symmetric encryption by matching polarisation
     * types received from the peer.
     * 
     * @param inputPolarisations The polarisations transmitted by the peer
     * @return The key decided on
     */
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

    /**
     * Transmits the polarisations used.
     * 
     * @return The polarisations used by this module.
     */
    public int[] transmitPolarisations() {
        return polarisations;
    }

    /**
     * Returns bits. Used only for testing
     * 
     * @return The bits for this module
     */
    public int[] getBits() {
        return bits;
    }

    /**
     * Sets bits. Used only for testing
     * 
     * @param bits
     */
    public void setBits(int[] bits) {
        this.bits = bits;
    }

    /**
     * Sets polarisations. Used only for testing
     * 
     * @param polarisations
     */
    public void setPolarisations(int[] polarisations) {
        this.polarisations = polarisations;
    }
}
