package encryptions;
import java.util.Scanner;

public class VigenereCipher {
    // Function to generate extended key for Vigenere cipher
    public static String generateKey(String plaintext, String key) {
        StringBuilder extendedKey = new StringBuilder();
        int keyLength = key.length();
        for (int i = 0, j = 0; i < plaintext.length(); i++) {
            extendedKey.append(key.charAt(j));
            j = (j + 1) % keyLength;
        }
        return extendedKey.toString();
    }

    // Function to perform Vigenere cipher encryption
    public static String cipherText(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char x = (char) ((plaintext.charAt(i) + key.charAt(i) - 2 * 'A') % 26 + 'A');
            ciphertext.append(x);
        }
        return ciphertext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get plaintext from user
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine().toUpperCase().replace(" ", "");

        // Get key from user
        System.out.print("Enter key: ");
        String key = scanner.nextLine().toUpperCase().replace(" ", "");

        // Generate extended key and encrypt plaintext
        String extendedKey = generateKey(plaintext, key);
        String ciphertext = cipherText(plaintext, extendedKey);

        // Output the results
        System.out.println("Key: " + key);
        System.out.println("Extended Key: " + extendedKey);
        System.out.println("Ciphertext: " + ciphertext);

        scanner.close();
    }
}
