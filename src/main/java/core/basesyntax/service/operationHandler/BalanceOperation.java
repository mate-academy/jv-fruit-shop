package core.basesyntax.service.operationHandler;

public class BalanceOperation implements OperationHandler{

    @Override
    public boolean provideOperation(String fruit, Integer amount) {
        return reportDataStorage.acceptData(fruit, amount);
    }
}
