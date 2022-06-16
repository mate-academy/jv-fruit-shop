package core.basesyntax.strategy.transaction;

public interface TransactionHandler {
    int getAmount(int amount, int newAmount);
}
