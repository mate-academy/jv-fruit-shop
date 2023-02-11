package core.basesyntax.strategy.transactions;

public interface TransactionHandler {
    void apply(FruitTransaction fruitTransactionImpl);
}
