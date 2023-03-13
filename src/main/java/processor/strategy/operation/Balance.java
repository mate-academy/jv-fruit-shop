package processor.strategy.operation;

import dao.DataDao;
import dao.impl.DataDaoImpl;
import processor.strategy.buffer.OperationBufferManager;

public class Balance implements Transaction {
    private final DataDao dataDao = new DataDaoImpl();

    @Override
    public void handleOperation() {
        String fruit = OperationBufferManager.getFruit();
        Integer balance = OperationBufferManager.getOperationAmount();
        if (dataDao.getValue(fruit) != null) {
            System.out.println("ATTENTION! Balance operation occurred more than once for: "
                    + fruit + "!\nCheck your storage workflow!");
        }
        dataDao.putValue(fruit, balance);
    }
}
