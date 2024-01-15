package core.basesyntax.operations;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public Integer getHandler(FruitTransaction fruitTransaction) {
        int newQuantity;
        if (storageDao.getValue(fruitTransaction.getFruit())
                < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Balance of "
                    + fruitTransaction.getFruit()
                    + " is less then "
                    + fruitTransaction.getQuantity());
        }
        newQuantity = storageDao.getValue(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        storageDao.add(new FruitTransaction(fruitTransaction.getOperation(),
                fruitTransaction.getFruit(),
                newQuantity));
        return newQuantity;
    }
}
