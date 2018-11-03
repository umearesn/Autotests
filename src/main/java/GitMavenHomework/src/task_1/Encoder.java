package task_1;

import javax.crypto.Cipher;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class Encoder extends Thread {
    private String email;
    private String password;
    private boolean isEncoding;
    private String aimFileName;

    Encoder(String input, boolean isEncoding, String aimFileName) {
        int i = 0;
        while (i < input.length() && input.charAt(i) != '|') {
            i++;
        }
        this.password = input.substring(0, i);
        this.email = input.substring(i + 1, input.length());
        this.isEncoding = isEncoding;
        this.aimFileName = aimFileName;
    }

    private byte[] readAsBytes(String filepath) throws IOException {
        try {
            return Files.readAllBytes(Paths.get(filepath));
        } catch (IOException error) {
            System.out.printf("\n%s", "Fail while reading as bytes.");
            return null;
        }
    }

    private PublicKey getPublic(String filepath) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        try {
            X509EncodedKeySpec keyBytes = new X509EncodedKeySpec(readAsBytes(filepath));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(keyBytes);
        } catch (IOException error) {
            System.out.printf("\n%s", "Fail while getting Public key: IOexception.");
            return null;
        } catch (InvalidKeySpecException error) {
            System.out.printf("\n%s", "Fail while getting Public key: InvalidKeySpecException.");
            return null;
        } catch (NoSuchAlgorithmException error) {
            System.out.printf("\n%s", "Fail while getting Public key: NoSuchAlgorithmException.");
            return null;
        }
    }

    private PrivateKey getPrivate(String filepath) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
    try{
        PKCS8EncodedKeySpec keyBytes = new PKCS8EncodedKeySpec(readAsBytes(filepath));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keyBytes);
    } catch(IOException error){
        System.out.printf("\n%s", "Fail while getting Private key: IOexception.");
        return null;
    } catch(InvalidKeySpecException error){
        System.out.printf("\n%s", "Fail while getting Private key: InvalidKeySpecException.");
        return null;
    } catch(NoSuchAlgorithmException error){
        System.out.printf("\n%s", "Fail while getting Private key: NoSuchAlgorithmException.");
        return null;
    }
}

    private static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(cipherText);
    }

    private static String decrypt(String cipherText, PrivateKey privateKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(cipherText);

        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        return new String(decryptCipher.doFinal(bytes), StandardCharsets.UTF_8);
    }

    @Override
    public void run() {
        try {
            KeyPair pair = new KeyPair(getPublic("src/main/java/GitMavenHomework/src/task_1/keys/rsapub.der"),
                    getPrivate("src/main/java/GitMavenHomework/src/task_1/keys/rsapriv.der"));
            String modPassword = "", modEmail = "";
            if(this.isEncoding) {
                modPassword = Base64.getEncoder().encodeToString(this.password.getBytes());
                modEmail = encrypt(this.email, pair.getPublic());
            } else {
                modPassword = new String(Base64.getMimeDecoder().decode(this.password));
                modEmail = decrypt(this.email, pair.getPrivate());
            }
            Output printer = new Output(modPassword.concat("|").concat(modEmail), this.aimFileName);
            printer.start();
        } catch (Exception err) {}
    }
}
