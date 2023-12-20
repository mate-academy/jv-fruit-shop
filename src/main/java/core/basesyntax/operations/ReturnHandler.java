package core.basesyntax.operations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public Integer getHandler(FruitTransaction fruitTransaction) {
        int newQuantity;
        if (storageDao.getBalance(fruitTransaction).getQuantity()
                >= fruitTransaction.getQuantity()) {
            newQuantity = storageDao.getBalance(fruitTransaction).getQuantity()
                    + fruitTransaction.getQuantity();
            storageDao.getBalance(fruitTransaction).setQuantity(newQuantity);
            return newQuantity;
        }
        throw new RuntimeException("Balance of "
                + fruitTransaction.getFruit()
                + " is less then "
                + fruitTransaction.getQuantity());
    }

}
