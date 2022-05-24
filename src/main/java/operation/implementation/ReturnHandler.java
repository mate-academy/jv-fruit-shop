package operation.implementation;

import dao.FruitDao;
import model.FruitTransaction;
import operation.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void getHandler(FruitTransaction fruitTransaction) {
        FruitTransaction fruitTransactionInDataBase = fruitDao.get(fruitTransaction.getFruit());
        if (fruitTransactionInDataBase == null) {
            fruitDao.add(fruitTransaction);
        } else {
            int amount = fruitTransactionInDataBase.getQuantity() + fruitTransaction.getQuantity();
            fruitTransactionInDataBase.setQuantity(amount);
            fruitDao.add(fruitTransactionInDataBase);
        }
    }
}
