package core.basesyntax.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int setDataInStorage(int amount, int newAmount) {
        return newAmount;
    }
}
