package core.basesyntax.operationstrategy.operation;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void processOperation(String item, Integer value) {
        STORAGE_DAO.addAmount(item, value);
    }
}
