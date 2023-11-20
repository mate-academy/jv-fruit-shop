package service.activities;

public class SupplyHandler implements OperationHandler {
    @Override
    public Integer executionOfOperation(Integer currentAction, Integer quantity) {
        return quantity + currentAction;
    }
}
