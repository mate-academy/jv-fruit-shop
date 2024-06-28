package core.basesyntax.service;

public interface DataConverter<T, R> {
    R convertToTransaction(T inputReport);
}
