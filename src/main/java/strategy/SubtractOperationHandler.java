package strategy;

import dao.FruitDao;
import model.FruitTransaction;
import service.OperationHandler;

public class SubtractOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SubtractOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        Integer availableQuantity = fruitDao.get(transaction.getFruit());
        Integer newAmount = availableQuantity != null
                ? availableQuantity - transaction.getQuantity() : transaction.getQuantity();
        fruitDao.add(transaction.getFruit(), newAmount);
    }
}
