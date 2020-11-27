package br.usjt.services;

import org.mindrot.jbcrypt.BCrypt;

import br.usjt.interfaces.Hash;

public class HashDriverImpl implements Hash {

    @Override
    public String hash(String input) {
        return BCrypt.hashpw(input, BCrypt.gensalt(10));
    }

    @Override
    public boolean compare(String hashedValue, String comparedValue) {
        return BCrypt.checkpw(comparedValue, hashedValue);
    }

}
