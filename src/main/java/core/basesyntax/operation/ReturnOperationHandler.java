package core.basesyntax.operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int setDataInStorage(int amount, int newAmount) {
        return amount + newAmount;
    }
}
