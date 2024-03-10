package service.operation;

import dao.FruitDao;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void operation(FruitTransaction transaction, FruitDao dao) {
        dao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
