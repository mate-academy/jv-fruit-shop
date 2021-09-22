package core.basesyntax.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int newAmountByOperation(int amount, int newAmount) {
        if (amount < newAmount) {
            throw new RuntimeException("Can't make purchase operation! "
                    + "Amount for buying bigger than fruit balance!");
        }
        return amount - newAmount;
    }
}
