package service.operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer getOperation(Integer input) {
        return input;
    }
}
