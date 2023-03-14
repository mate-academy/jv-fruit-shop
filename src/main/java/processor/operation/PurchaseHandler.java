package processor.operation;

import dao.DataDao;
import dao.impl.DataDaoImpl;
import exception.ReportException;
import model.OperationUnit;

public class PurchaseHandler implements OperationHandler {
    private final DataDao dataDao = new DataDaoImpl();

    @Override
    public void handleOperation(OperationUnit operationUnit) {
        String fruit = operationUnit.getFruit();
        Integer storedAmount = operationUnit.getStoredAmount();
        if (storedAmount == null) {
            throw new ReportException("Balance had not been set for " + fruit);
        }
        Integer resultingAmount = storedAmount - operationUnit.getOperationAmount();
        if (resultingAmount < 0) {
            throw new ReportException("Input data falsified! Negative amount calculated for "
                    + fruit);
        }
        dataDao.putValue(fruit, resultingAmount);
    }
}
