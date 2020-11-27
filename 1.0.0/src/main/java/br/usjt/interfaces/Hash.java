package br.usjt.interfaces;

public interface Hash {
    String hash(String input);
    boolean compare(String hashValue, String comparedValue);
}
