package core.basesyntax.operation.handler;

public class BalanceOperation extends AbstractOperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        storageDao.add(fruit, quantity);
    }
}
