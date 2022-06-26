package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.strategy.OperationHandler;
import java.util.Optional;

public class SupplyHandler implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeOperation(FruitShopTransactions fruitTransaction) {
        Optional<Integer> newQuantity = storageDao.getCurrentQuantity(fruitTransaction.getFruit());
        storageDao.update(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity() + newQuantity.orElse(0));
    }
}
