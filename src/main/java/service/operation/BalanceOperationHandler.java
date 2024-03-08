package service.operation;

import dao.FruitDao;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operation(FruitTransaction transaction, FruitDao dao) {
        dao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
