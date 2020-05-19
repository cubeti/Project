package org.sef.student.Services;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;

class Encryption{

    Cipher ecipher;
    Cipher dcipher;

    Encryption(SecretKey key) throws Exception {
        ecipher = Cipher.getInstance("AES");
        dcipher = Cipher.getInstance("AES");
        ecipher.init(Cipher.ENCRYPT_MODE, key);
        dcipher.init(Cipher.DECRYPT_MODE, key);
    }

    public String encrypt(String str) throws Exception {
        // Encode the string into bytes using utf-8
        byte[] utf8 = str.getBytes("UTF8");

        // Encrypt
        byte[] enc = ecipher.doFinal(utf8);

        // Encode bytes to base64 to get a string
        Base64.Encoder e=Base64.getEncoder();
        return new String(e.encode(enc));
    }

    public String decrypt(String str) throws Exception {
        // Decode base64 to get bytes
        Base64.Decoder e=Base64.getDecoder();
        byte[] dec=e.decode(str);
        byte[] utf8 = dcipher.doFinal(dec);

        // Decode using utf-8
        return new String(utf8, "UTF8");
    }


    /*public static void main(String args []) throws Exception
    {

        String data = "Don't tell anybody!";
        String k = "Bar12345Bar12345";

        //SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        SecretKey key = new SecretKeySpec(k.getBytes(), "AES");
        EncryptionDemo encrypter = new EncryptionDemo(key);

        System.out.println("Original String: " + data);

        String encrypted = encrypter.encrypt(data);

        System.out.println("Encrypted String: " + encrypted);

        String decrypted = encrypter.decrypt(encrypted);

        System.out.println("Decrypted String: " + decrypted);
    }*/
}