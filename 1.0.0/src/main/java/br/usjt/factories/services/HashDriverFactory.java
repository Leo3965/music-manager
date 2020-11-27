package br.usjt.factories.services;

import br.usjt.services.HashDriverImpl;
import br.usjt.interfaces.Hash;

public class HashDriverFactory {
    public static Hash get() {
        return new HashDriverImpl();
    }
}
