package core.basesyntax.strategy;

public interface FruitTransactionStrategy {
    FruitTransactionHandler getTransaction(String transaction);
}
