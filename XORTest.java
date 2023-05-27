import java.util.Random;
import org.junit.jupiter.api.*;

public class XORTest {

    @Test
    @DisplayName("XOR test")
    public void XORValidKeyTest() {
        String message = "Testing Message!";
        Random rnd = new Random();

        // Key length between 1 and 16
        int keyLength = rnd.nextInt(16) + 1;

        int[] key = new int[keyLength];

        // Create random xor key
        for (int i = 0; i < keyLength; i++) {
            key[i] = rnd.nextInt(2);
        }

        // Encode and decode to assert result
        byte[] encoded = XOR.encode(key, message);
        String decoded = XOR.decode(key, encoded);

        Assertions.assertTrue(message.equals(decoded));
    }

    @Test
    @DisplayName("XOR with 0 length key")
    public void XORInvalidKeyTest() {
        String message = "Testing Message!";

        // Key with no length
        int[] key = new int[0];

        // Encode and decode to assert result
        byte[] encoded = XOR.encode(key, message);
        String decoded = XOR.decode(key, encoded);

        Assertions.assertTrue(message.equals(decoded));
    }
}
