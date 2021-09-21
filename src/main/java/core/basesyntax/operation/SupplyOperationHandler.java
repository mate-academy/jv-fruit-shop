package core.basesyntax.operation;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int setDataInStorage(int amount, int newAmount) {
        return amount + newAmount;
    }
}
