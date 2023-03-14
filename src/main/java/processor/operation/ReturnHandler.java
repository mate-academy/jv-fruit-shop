package processor.operation;

import dao.DataDao;
import dao.impl.DataDaoImpl;
import exception.ReportException;
import model.OperationUnit;

public class ReturnHandler implements OperationHandler {
    private final DataDao dataDao = new DataDaoImpl();

    @Override
    public void handleOperation(OperationUnit operationUnit) {
        String fruit = operationUnit.getFruit();
        Integer storedAmount = operationUnit.getStoredAmount();
        if (storedAmount == null) {
            throw new ReportException("Balance had not been set for " + fruit);
        }
        dataDao.putValue(fruit, storedAmount + operationUnit.getOperationAmount());
    }
}
