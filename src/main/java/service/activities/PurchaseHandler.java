package service.activities;

public class PurchaseHandler implements OperationHandler {
    @Override
    public Integer executionOfOperation(Integer currentAction, Integer quantity) {
        return quantity - currentAction;
    }
}
