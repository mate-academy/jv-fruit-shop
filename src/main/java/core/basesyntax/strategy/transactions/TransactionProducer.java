package core.basesyntax.strategy.transactions;

public interface TransactionProducer {
    void produceTransaction(FruitTransaction fruitTransactionImpl);
}
