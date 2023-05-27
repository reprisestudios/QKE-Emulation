import java.nio.charset.StandardCharsets;

public class XOR {

    public static String decode(int[] key, byte[] bytes) {
        return new String(cipher(key, bytes), StandardCharsets.UTF_8);
    }

    public static byte[] encode(int[] key, String message) {
        return cipher(key, message.getBytes(StandardCharsets.UTF_8));
    }

    private static byte[] cipher(int[] key, byte[] message) {
        int keyIndex = 0;
        byte[] newBytes = new byte[message.length];

        int byteCount = 0;

        // For each byte
        for (byte b : message) {
            byte newByte = b;

            // For each bit
            for (int i = 0; i < 8; i++) {
                // Repeat the key if required
                if (keyIndex >= key.length) {
                    keyIndex = 0;
                }

                // Get the state of the current key index and the current bit
                boolean keyState = (key[keyIndex] != 0);
                boolean bitState = getBit(b, i);

                // Xor both to get the new bit state
                boolean newState = keyState ^ bitState;

                // Set the bit to the new bit state
                newByte = setBit(newByte, i, newState);

                keyIndex++;
            }

            newBytes[byteCount] = newByte;
            byteCount++;
        }

        return newBytes;
    }

    private static byte setBit(byte _byte, int bitPosition, boolean bitValue) {
        if (bitValue)
            return (byte) (_byte | (1 << bitPosition));
        return (byte) (_byte & ~(1 << bitPosition));
    }

    private static Boolean getBit(byte _byte, int bitPosition) {
        return (_byte & (1 << bitPosition)) != 0;
    }
}
