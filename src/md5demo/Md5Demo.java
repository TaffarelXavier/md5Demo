/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md5demo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Random;

/**
 *
 * @author Taffarel
 */
public class Md5Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int x : gerarNumeros(12)) {
            System.out.println(x);
        }
    }
    /**
     * <p style="font:16px arial">Gerar número aleatórios e únicos</p>
     * @param total A quantidade de números gerados
     * @return Array
     */
    public static int[] gerarNumeros(int total) {
        
        int[] numeros = new int[total];
        
        for (int x = 0; x < total; x++) {
            Random random = new Random(System.nanoTime() % 100000);
            int randomInt = random.nextInt(1000000000);
            numeros[x] = Integer.parseInt(String.valueOf(randomInt).substring(0, 3));
        }

        return numeros;
    }

    public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(base.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String MD5(String md5) {

        try {

            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");

            byte[] array = md.digest(md5.getBytes());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < array.length; ++i) {

                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));

            }

            return sb.toString();

        } catch (java.security.NoSuchAlgorithmException e) {

        }

        return null;

    }

}
