///Name: Ethyn Gillies
///ID: 1503149

import java.util.Random;

public class Qubit {

    int value;
    int polarisation;

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