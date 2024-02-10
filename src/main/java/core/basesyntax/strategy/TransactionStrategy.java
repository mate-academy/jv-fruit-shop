package core.basesyntax.strategy;

public interface TransactionStrategy {
    int balanceUpdater(int balance, String quantity);
}
