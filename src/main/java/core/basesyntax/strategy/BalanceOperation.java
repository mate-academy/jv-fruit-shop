package core.basesyntax.strategy;

public class BalanceOperation implements OperationHandler {
    @Override
    public int warehouse(int balance, int quantity) {
        return balance;
    }
}
