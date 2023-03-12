package processor.strategy.operation;

import model.ReportException;
import service.DataStorageService;
import service.impl.DataStorageServiceImpl;
import storage.OperationalStorage;

public class Return implements Transaction {
    private final DataStorageService dataStorageService = new DataStorageServiceImpl();

    @Override
    public void handleOperation() {
        String fruit = OperationalStorage.getFruit();
        Integer storedAmount = OperationalStorage.getStoredAmount();
        if (storedAmount == null) {
            throw new ReportException("Balance had not been set for " + fruit);
        }
        Integer resultingAmount = storedAmount + OperationalStorage.getOperationAmount();
        dataStorageService.putValue(fruit, resultingAmount);
    }
}
