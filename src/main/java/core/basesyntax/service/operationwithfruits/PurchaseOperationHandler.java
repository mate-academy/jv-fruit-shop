package core.basesyntax.service.operationwithfruits;

public class PurchaseOperationHandler implements OperationHandler {
    public Integer getOperation(Integer count) {
        return -count;
    }
}
