package br.usjt.factories.infrastructure.drivers;

import br.usjt.domain.contracts.Hash;
import br.usjt.infrastructure.drivers.HashDriverImpl;

public class HashDriverFactory {
    public static Hash get() {
        return new HashDriverImpl();
    }
}
