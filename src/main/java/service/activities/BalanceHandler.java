package service.activities;

public class BalanceHandler implements OperationHandler {

    @Override
    public Integer executionOfOperation(Integer currentAction, Integer quantity) {
        return quantity + currentAction;
    }
}
