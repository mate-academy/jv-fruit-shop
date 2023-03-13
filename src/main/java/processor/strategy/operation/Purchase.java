package processor.strategy.operation;

import dao.DataDao;
import dao.impl.DataDaoImpl;
import exception.ReportException;
import processor.strategy.buffer.OperationBufferManager;

public class Purchase implements Transaction {
    private final DataDao dataDao = new DataDaoImpl();

    @Override
    public void handleOperation() {
        String fruit = OperationBufferManager.getFruit();
        Integer storedAmount = OperationBufferManager.getStoredAmount();
        if (storedAmount == null) {
            throw new ReportException("Balance had not been set for " + fruit);
        }
        Integer resultingAmount = storedAmount - OperationBufferManager.getOperationAmount();
        if (resultingAmount < 0) {
            throw new ReportException("Input data falsified! Negative amount calculated for "
                    + fruit);
        }
        dataDao.putValue(fruit, resultingAmount);
    }
}
