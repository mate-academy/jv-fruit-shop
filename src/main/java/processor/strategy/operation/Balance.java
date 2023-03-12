package processor.strategy.operation;

import service.DataStorageService;
import service.impl.DataStorageServiceImpl;
import storage.OperationalStorage;

public class Balance implements Transaction {
    private final DataStorageService dataStorageService = new DataStorageServiceImpl();

    @Override
    public void handleOperation() {
        String fruit = OperationalStorage.getFruit();
        Integer balance = OperationalStorage.getOperationAmount();
        dataStorageService.putValue(fruit, balance);
    }
}
