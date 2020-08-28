package core.basesyntax.service;

public interface Convertable<T, R> {
    T convert(R row);
}
