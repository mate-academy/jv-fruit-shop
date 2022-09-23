package core.basesyntax.service.operationwithfruits;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer getOperation(Integer count) {
        return count;
    }
}
