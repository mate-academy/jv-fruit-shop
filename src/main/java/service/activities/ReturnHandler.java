package service.activities;

public class ReturnHandler implements OperationHandler {
    @Override
    public Integer executionOfOperation(Integer currentAction, Integer quantity) {
        return quantity + currentAction;
    }
}
