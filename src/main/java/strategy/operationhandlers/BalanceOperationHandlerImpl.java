package strategy.operationhandlers;

import dao.FruitQuantityStorageDao;
import dao.FruitQuantityStorageDaoImpl;
import model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private FruitQuantityStorageDao dao = new FruitQuantityStorageDaoImpl();

    @Override
    public void getOperationQuantity(FruitTransaction transaction) {
        dao.add(transaction.getName(), transaction.getQuantity());
    }
}
