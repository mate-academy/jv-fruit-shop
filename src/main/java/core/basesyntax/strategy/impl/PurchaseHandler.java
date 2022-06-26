package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.strategy.OperationHandler;
import java.util.Optional;

public class PurchaseHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeOperation(FruitShopTransactions fruitTransaction) {
        Optional<Integer> newQuantity = storageDao.getCurrentQuantity(fruitTransaction.getFruit());
        if (newQuantity.orElse(0) < fruitTransaction.getQuantity()) {
            throw new RuntimeException("There are no enough "
                    + fruitTransaction.getFruit()
                    + " for purhase operation, remaining: " + newQuantity.orElse(0)
                    + ", trying to buy: " + fruitTransaction.getQuantity());
        }
        storageDao.update(fruitTransaction.getFruit(),
                newQuantity.orElse(0) - fruitTransaction.getQuantity());
    }
}
