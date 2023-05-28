///Name: Ethyn Gillies
///ID: 1503149

import java.util.Random;

public class Qubit {

    int value;
    int polarisation;

    /**
     * Defines a Qubit
     * 
     * @param value        The value to set
     * @param polarisation The qubits polarisation
     */
    public Qubit(int value, int polarisation) {
        if (value > 1 || value < 0) {
            return;
        }

        if (polarisation > 1 || polarisation < 0) {
            return;
        }

        this.value = value;
        this.polarisation = polarisation;
    }

    /**
     * Sets the value and polarisation of this qubit
     * 
     * @param value        The value to set
     * @param polarisation The qubits polarisation
     */
    public void set(int value, int polarisation) {
        if (value > 1 || value < 0) {
            return;
        }

        if (polarisation > 1 || polarisation < 0) {
            return;
        }

        this.value = value;
        this.polarisation = polarisation;
    }

    /**
     * Measures a qubit using a specified polarisation.
     * If the polarisation matches the qubits polarisation, the value will return.
     * If the polarisation doesnt match, the qubits polarisation will change to the
     * measured
     * polarisations and the value will be randomised to either 1 or 0.
     * 
     * @param polarisation The polarisation to measure with
     * @return The value of this qubit if the polarisation matches, or a random bit
     *         if not
     */
    public int measure(int polarisation) {
        if (polarisation == this.polarisation) {
            return value;
        } else {
            Random rnd = new Random();
            this.value = rnd.nextInt(2);
            this.polarisation = polarisation;
            return this.value;
        }
    }
}