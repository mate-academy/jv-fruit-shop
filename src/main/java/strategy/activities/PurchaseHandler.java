package strategy.activities;

public class PurchaseHandler implements OperationHandler {
    @Override
    public Integer executionOfOperation(Integer currentAction, Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Balance is negative!");
        }
        return quantity - currentAction;
    }
}
