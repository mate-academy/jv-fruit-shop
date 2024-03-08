package service.operation;

import dao.FruitDao;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operation(FruitTransaction transaction, FruitDao dao) {
        dao.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
