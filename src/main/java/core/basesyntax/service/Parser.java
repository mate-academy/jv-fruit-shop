package core.basesyntax.service;

public interface Parser<T> {
    T parseLine(String line, Validator validator);
}
