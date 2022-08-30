package core.basesyntax.strategy.handler;

public interface TransactionHandler<T> {
    void makeTransaction(T transaction);
}
