package br.usjt.domain.contracts;

public interface Hash {
    String hash(String input);

    boolean compare(String hashValue, String comparedValue);
}
