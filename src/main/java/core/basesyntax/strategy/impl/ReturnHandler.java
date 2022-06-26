package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.strategy.OperationHandler;
import java.util.Optional;

public class ReturnHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeOperation(FruitShopTransactions fruitTransaction) {
        Optional<Integer> newQuantity = storageDao.getCurrentQuantity(fruitTransaction.getFruit());
        storageDao.update(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity() + newQuantity.orElse(0));
    }
}
