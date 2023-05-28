///Name: Ethyn Gillies
///ID: 1503149

import org.junit.jupiter.api.*;

public class ModuleTest {

        @Test
        @DisplayName("Match Qubits Test")
        public void matchQubitsTest() {
                // Polarisations and bits setting
                Module module = new Module();
                int[] initialPolarisations = new int[] {
                                1, 0, 0, 1, 0, 1, 1, 1
                };

                int[] newPolarisations = new int[] {
                                1, 0, 1, 0, 0, 1, 0, 0
                };

                int[] bits = new int[] {
                                0, 0, 1, 0, 1, 1, 0, 1
                };

                module.setPolarisations(initialPolarisations);
                module.setBits(bits);

                int[] key = module.matchQubits(newPolarisations);

                // Expected key output
                int[] expected = new int[] {
                                0, 0, 1, 1
                };

                Assertions.assertArrayEquals(expected, key);
        }
}
