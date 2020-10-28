package br.usjt.infrastructure.drivers;

import java.security.MessageDigest;

import br.usjt.domain.contracts.Hash;

public class HashDriverImpl implements Hash {

    @Override
    public String hash(String input) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte messageDigest[] = algorithm.digest(input.getBytes("UTF-8"));

            return messageDigest.toString();
        } catch (Exception ex) {
            return "";
        }
    }

    @Override
    public boolean compare(String hashedValue, String comparedValue) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte messageDigest[] = algorithm.digest(comparedValue.getBytes("UTF-8"));

            return hashedValue.equals(hashedValue);
        } catch (Exception ex) {
            return false;
        }
    }

}
