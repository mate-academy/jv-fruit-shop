package core.basesyntax.operationstrategy.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void processOperation(String item, Integer value) {
        STORAGE_DAO.substractAmount(item, value);
    }
}
