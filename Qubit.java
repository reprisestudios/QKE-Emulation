///Name: Ethyn Gillies
///ID: 1503149

import java.util.Random;

public class Qubit {

    int value;
    int polarisation;

    public void newQubit(int value, int polarisation) {
        this.value = value;
        this.polarisation = polarisation;
    }

    public void setQubit(int value, int polarisation) {
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