package core.basesyntax.operationstrategy.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void processOperation(String item, Integer value) {
        STORAGE_DAO.add(item, value);
    }
}
