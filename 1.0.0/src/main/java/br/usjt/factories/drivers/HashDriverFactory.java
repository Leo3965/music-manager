package br.usjt.factories.drivers;

import br.usjt.drivers.HashDriverImpl;
import br.usjt.interfaces.Hash;

public class HashDriverFactory {
    public static Hash get() {
        return new HashDriverImpl();
    }
}
