package processor.operation;

import dao.DataDao;
import dao.impl.DataDaoImpl;
import model.OperationUnit;

public class BalanceHandler implements OperationHandler {
    private final DataDao dataDao = new DataDaoImpl();

    @Override
    public void handleOperation(OperationUnit operationUnit) {
        dataDao.putValue(operationUnit.getFruit(), operationUnit.getOperationAmount());
    }
}
