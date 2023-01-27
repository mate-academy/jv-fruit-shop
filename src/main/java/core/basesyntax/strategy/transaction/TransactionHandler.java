package core.basesyntax.strategy.transaction;

public interface TransactionHandler {
    void doTransaction(String fruitType, int quantity);
}
