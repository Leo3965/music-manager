package br.usjt.infrastructure.drivers;

import br.usjt.domain.contracts.Hash;
import org.mindrot.jbcrypt.BCrypt;

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
