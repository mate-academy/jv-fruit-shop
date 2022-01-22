package core.basesyntax.service;

public interface Parser<T> {
    T parseTo(String line);
}
