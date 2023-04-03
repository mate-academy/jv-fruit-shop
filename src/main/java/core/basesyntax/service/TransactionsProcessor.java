package core.basesyntax.service;

public interface TransactionsProcessor<T, K> {
    K process(T data);
}
