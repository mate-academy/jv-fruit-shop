package core.basesyntax.services;

public interface Validator {
    void validate(String line) throws RuntimeException;
}
