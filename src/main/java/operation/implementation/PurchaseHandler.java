package operation.implementation;

import dao.FruitDao;
import model.FruitTransaction;
import operation.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void getHandler(FruitTransaction fruitTransaction) {
        FruitTransaction fruitTransactionInDataBase = fruitDao.get(fruitTransaction.getFruit());
        if (fruitTransactionInDataBase == null) {
            throw new RuntimeException(fruitTransaction.getFruit() + " is not available now");
        }
        int difference = fruitTransactionInDataBase.getQuantity() - fruitTransaction.getQuantity();
        if (difference < 0) {
            throw new RuntimeException(fruitTransaction.getFruit() + " is not enough in shop now");
        }
        fruitTransactionInDataBase.setQuantity(difference);
        fruitDao.add(fruitTransactionInDataBase);
    }
}
