package core.basesyntax.service.strategy;

public interface TransactionStrategy<T> {
    void getOperation(T t);
}
