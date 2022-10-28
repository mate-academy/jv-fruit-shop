package core.basesyntax.strategy.transactions;

public interface TransactionHandler {
    void produceTransaction(FruitTransaction fruitTransactionImpl);
}
