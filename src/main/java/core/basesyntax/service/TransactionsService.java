package core.basesyntax.service;

public interface TransactionsService<T, K> {
    K process(T data);
}
