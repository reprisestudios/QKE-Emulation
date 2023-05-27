public class QKEEmulation {

    public static void main(String[] args) {
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

        Transmitter transmitter = new Transmitter();
        Receiver receiver = new Receiver();

        Qubit[] sentQubits = transmitter.randomiseQubits(streamLength);

        receiver.readQubits(sentQubits);

        int[] transmitterPolarisations = transmitter.transmitPolarisations();
        int[] receiverPolarisations = receiver.transmitPolarisations();

        int[] transmitterKey = transmitter.matchQubits(receiverPolarisations);
        int[] receiverKey = receiver.matchQubits(transmitterPolarisations);

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
    }
}
