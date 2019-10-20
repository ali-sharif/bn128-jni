package org.aion.tetryon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.math.BigInteger;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class G16SquarePreimageTest {
	// positive test-case for square pre-image verifier: a=337, b=113569 (a^2 == b)
    @Test
    public void verifyTest() {
        G1Point a = new G1Point(
                new Fp(new BigInteger("07f4a1ab12b1211149fa0aed8ade3442b774893dcd1caffb8693ade54999c164", 16)),
                new Fp(new BigInteger("23b7f10c5e1aeaffafa088f1412c0f307969ba3f8f9d5920214a4cb91693fab5", 16)));

        G2Point b = new G2Point(
                new Fp2(new BigInteger("1f6cc814cf1df1ceb663378c496f168bcd21e19bb529e90fcf3721f8df6b4128", 16),
                        new BigInteger("079ee30e2c79e15be67645838a3177f681ab111edacf6f4867e8eed753ed9681", 16)),
                new Fp2(new BigInteger("2779dd0accaa1391e29ad54bf065819cac3129edda4eaf909d6ea2c7495a47f7", 16),
                        new BigInteger("20105b11ae5fbdc7067102d4260c8913cdcb512632680221d7644f9928a7e51d", 16)));

        G1Point c = new G1Point(
                new Fp(new BigInteger("153c3a313679a5c11010c3339ff4f787246ed2e8d736efb615aeb321f5a22432", 16)),
                new Fp(new BigInteger("06691d8441c35768a4ca87a5f5ee7d721bf13115d2a16726c12cda295a19bf09", 16)));


        BigInteger[] input = new BigInteger[]{
                new BigInteger("000000000000000000000000000000000000000000000000000000000001bba1", 16),
                new BigInteger("0000000000000000000000000000000000000000000000000000000000000001", 16)};

        // transaction should succeed
        assertTrue(G16Verifier.verify(input, new G16Verifier.Proof(a, b, c)));
    }

    // negative test-case for square pre-image verifier: a=337, b=113570 (a^2 != b)
    @Test
    public void rejectTest() {
        G1Point a = new G1Point(
                new Fp(new BigInteger("1946d8503f2bddd05511bfcebc502a620055b4c3d2c3c104e5c473d15b789a80", 16)),
                new Fp(new BigInteger("1d1f8fffa65efb700e695f25f2a932385c144e7e964c85b9d74cca78672834ec", 16)));

        G2Point b = new G2Point(
                new Fp2(new BigInteger("2354063529fbbd0688744273b329b6b3d6a6f9d7a837dccb1617cb0e52d72609", 16),
                        new BigInteger("1af73fa504d700c6e2f7730940a0139319264a6463c4303878aab72cf0e5e2b2", 16)),
                new Fp2(new BigInteger("08645e9bbd3baef396dce9efcc844d79c191a2f6c1ab1c87fb3859c76da9ee43", 16),
                        new BigInteger("0c48749defa64ff75dd86b4cf4efaa5a4c45ed17ca25efb8ea9b183eccee1303", 16)));

        G1Point c = new G1Point(
                new Fp(new BigInteger("15ee5aef1ee660c3e4abecf8c31960b4ae106918ae8d403138607413a4d75f38", 16)),
                new Fp(new BigInteger("066d8491786dbf2d5e45a4006a7252333c8ffb083e3b60d00c4c9044ae9a5760", 16)));


        BigInteger[] input = new BigInteger[]{
                new BigInteger("000000000000000000000000000000000000000000000000000000000001bba2", 16),
                new BigInteger("0000000000000000000000000000000000000000000000000000000000000000", 16)};

        // transaction should succeed
        assertFalse(G16Verifier.verify(input, new G16Verifier.Proof(a, b, c)));
    }

    /**
     * Hello world example (g16). Auto-generated by Zokrates.
     *
     * Circuit accepts two arguments (private: a, public: b); generates proof for statement a^2 == b
     * (i.e. I know some 'a', such that a^2 == b, for some publicly known 'b', without revealing the value for 'a').
     */
    public static class G16Verifier {
        protected static class VerifyingKey {
            public final G1Point alpha;
            public final G2Point beta;
            public final G2Point gamma;
            public final G2Point delta;
            public final G1Point[] gamma_abc;

            public VerifyingKey(G1Point alpha, G2Point beta, G2Point gamma, G2Point delta, G1Point[] gamma_abc) {
                this.alpha = alpha;
                this.beta = beta;
                this.gamma = gamma;
                this.delta = delta;
                this.gamma_abc = gamma_abc;
            }
        }

        protected static class Proof {
            public final G1Point a;
            public final G2Point b;
            public final G1Point c;

            public Proof(G1Point a, G2Point b, G1Point c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }
        }

        protected static VerifyingKey verifyingKey() {
            G1Point alpha = new G1Point(
                    new Fp(new BigInteger("0019120ee247a3e5c0c710de50f86f8be890b9f8ce35591abf182f4d591db8f8", 16)),
                    new Fp(new BigInteger("087d9b6ea30dc1fefda2468a53b82005fabfcdd026cee359444642ac16e14e9c", 16))
            );
            G2Point beta = new G2Point(
                    new Fp2(new BigInteger("2c76e975c13721befe2860550097061edad5d5e6d4b55d7e0888aa4081bb1b70", 16),
                            new BigInteger("03beea23c38a06edc9577b174c9e046789291db7ef51251e02e053adf41d6ab1", 16)),
                    new Fp2(new BigInteger("11820c74e2c88cebeb132852cb0b02fdd23cc77e2927fe70c96bee0342c11c2f", 16),
                            new BigInteger("15383eda06e6734eedcdea2d7564c1827bca49490452bc70374e07d13a3a38ea", 16))
            );
            G2Point gamma = new G2Point(
                    new Fp2(new BigInteger("125c637232482e34cf00c0c6393bafe26e310343f4f6383cf6e65ff2a8fab351", 16),
                            new BigInteger("23d45e985239a8c7d0cd091c66fd204d530df129ebbde3cba00950360f60a0bb", 16)),
                    new Fp2(new BigInteger("1bce5f9e19392c141016211714944bf88222d77059a7b8939de4d942bfb815b6", 16),
                            new BigInteger("133f401b96c4165c139e22e7dadf859a3a2169485bc9f462042779b76820f444", 16))
            );
            G2Point delta = new G2Point(
                    new Fp2(new BigInteger("2d218c6c3c97d36c6a36bdae8aaad026787d5d7bc73fcac935302901cccc8cac", 16),
                            new BigInteger("07dcfa8f6093776cc7003f0a7655178642c624b5158f7767d446e99123569668", 16)),
                    new Fp2(new BigInteger("0d34b1da6e22c6fc31ad42e9165598572c98c591e03877bf398d95fc620fc7a9", 16),
                            new BigInteger("1375019c6afcce46743219e2584f57fac17a99f6f105c47d77ccc15f4a12514f", 16))
            );
            G1Point[] gamma_abc = new G1Point[]{
                    new G1Point(
                            new Fp(new BigInteger("2da89765d6c25c6d0d63a767bf9d30a7e6b4c040663a8dc1a1a002085d1009c3", 16)),
                            new Fp(new BigInteger("03beb639535322312a2eace06a3ffad50e09fbd12d4762553c166d7e47b20af9", 16))),
                    new G1Point(
                            new Fp(new BigInteger("1e870e8b098c7053a851060c1d965b9e177a37c4a6c3bfa9539733ad48704871", 16)),
                            new Fp(new BigInteger("279795f70d42bfe052be9153148c6d16b63bf4564172d45666535882ffd21070", 16))),
                    new G1Point(
                            new Fp(new BigInteger("126b7087066e197fd44591d3f9f2df60fa08cc5030f38f5671a13b4bd7d0cd25", 16)),
                            new Fp(new BigInteger("1404cadb49f2910570d68c8163766e71a92676bc3f24c6118574a3ecbd4f0578", 16)))
            };
            return new VerifyingKey(alpha, beta, gamma, delta, gamma_abc);
        }

        public static boolean verify(BigInteger[] input, Proof proof) {
            BigInteger snarkScalarField = new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617");
            VerifyingKey vk = verifyingKey();
            require(input.length + 1 == vk.gamma_abc.length);

            // X = gamma_0 + gamma_1 * input_0 + gamma_2 * input_1
            G1Point X = new G1Point(Fp.zero(), Fp.zero());
            for (int i = 0; i < input.length; i++) {
                require(input[i].compareTo(snarkScalarField) < 0);
                G1Point tmp = G1.mul(vk.gamma_abc[i + 1], input[i]);
                if (i == 0)
                    X = tmp;
                else
                    X = G1.add(X, tmp);
            }
            X = G1.add(X, vk.gamma_abc[0]);

            // See [Groth16]
            // [A]_1 * [B]_2 = [alpha]_1 * [beta]_2 + [X]_1 * [gamma]_2 + [C]_1 * [delta]_2
            // e(A, B)
            // e(-X, gamma)
            // e(-C, delta)
            // e(-alpha, beta)
            return Pairing.pairingProd4(
                                proof.a, proof.b,
                                G1.negate(X), vk.gamma,
                                G1.negate(proof.c), vk.delta,
                                G1.negate(vk.alpha), vk.beta);
        }

        private static void require(boolean condition) {
            if (!condition) {
                throw new IllegalArgumentException();
            }
        }
    }

}
