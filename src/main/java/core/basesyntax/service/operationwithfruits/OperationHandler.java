package core.basesyntax.service.operationwithfruits;

public interface OperationHandler {
    default Integer getOperation(Integer count) {
        return count;
    }
}
