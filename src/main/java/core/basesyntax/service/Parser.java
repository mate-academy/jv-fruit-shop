package core.basesyntax.service;

public interface Parser<T> {
    T parser(String row);
}
