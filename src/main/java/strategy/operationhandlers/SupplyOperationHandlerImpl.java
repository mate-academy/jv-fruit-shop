package strategy.operationhandlers;

import dao.FruitQuantityStorageDao;
import dao.FruitQuantityStorageDaoImpl;
import model.FruitTransaction;

public class SupplyOperationHandlerImpl implements OperationHandler {

    private FruitQuantityStorageDao dao = new FruitQuantityStorageDaoImpl();

    @Override
    public void getOperationQuantity(FruitTransaction transaction) {
        int oldQuantity = dao.get(transaction.getName());
        dao.add(transaction.getName(), oldQuantity
                + transaction.getQuantity());
    }
}
