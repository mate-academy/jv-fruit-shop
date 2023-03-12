package processor.strategy.operation;

import model.ReportException;
import service.DataStorageService;
import service.impl.DataStorageServiceImpl;
import storage.OperationalStorage;

public class Purchase implements Transaction {
    private final DataStorageService dataStorageService = new DataStorageServiceImpl();

    @Override
    public void handleOperation() {
        String fruit = OperationalStorage.getFruit();
        Integer storedAmount = OperationalStorage.getStoredAmount();
        if (storedAmount == null) {
            throw new ReportException("Balance had not been set for " + fruit);
        }
        Integer resultingAmount = storedAmount - OperationalStorage.getOperationAmount();
        if (resultingAmount < 0) {
            throw new ReportException("Input data falsified! Negative amount calculated for "
                    + fruit);
        }
        dataStorageService.putValue(fruit, resultingAmount);
    }
}
