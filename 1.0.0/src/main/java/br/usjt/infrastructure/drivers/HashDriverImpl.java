package br.usjt.infrastructure.drivers;

import br.usjt.domain.contracts.Hash;

public class HashDriverImpl implements Hash {

    @Override
    public String hash(String input) {
        return input;
    }

    @Override
    public boolean compare(String hashValue, String comparedValue) {
        return hashValue.equals(comparedValue);
    }

}
