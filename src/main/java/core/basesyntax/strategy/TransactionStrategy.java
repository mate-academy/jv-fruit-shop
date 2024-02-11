package core.basesyntax.strategy;

public interface TransactionStrategy {
    Integer balanceUpdater(String fruitName, int quantity);
}
