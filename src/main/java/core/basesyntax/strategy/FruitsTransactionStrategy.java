package core.basesyntax.strategy;

public interface FruitsTransactionStrategy {
    FruitHandler fruitHandler(String transactionType);
}
