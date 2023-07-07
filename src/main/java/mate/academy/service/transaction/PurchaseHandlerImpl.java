package mate.academy.service.transaction;

import mate.academy.dao.FruitDao;
import mate.academy.dao.FruitDaoImpl;
import mate.academy.model.FruitTransaction;

public class PurchaseHandlerImpl implements TransactionHandler {
    private final FruitDao fruitDao;

    public PurchaseHandlerImpl() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int oldQuantity = fruitDao.getQuantity(transaction.getFruit());
        int newQuantity = oldQuantity - transaction.getQuantity();
        isFruitAvailable(newQuantity, transaction);
        fruitDao.add(transaction.getFruit(), newQuantity);
    }

    private void isFruitAvailable(int newQuantity, FruitTransaction transaction) {
        if (newQuantity < 0) {
            throw new RuntimeException("The store is missing "
                    + newQuantity * -1
                    + " "
                    + transaction.getFruit());
        }
    }

}
