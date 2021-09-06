package core.basesyntax.service.operationHandler;

public class ReturnOperation implements OperationHandler{
    @Override
    public boolean provideOperation(String fruit, Integer amount) {
        return reportDataStorage.acceptData(fruit, reportDataStorage.getDataPerFruit(fruit) + amount);
    }
}
