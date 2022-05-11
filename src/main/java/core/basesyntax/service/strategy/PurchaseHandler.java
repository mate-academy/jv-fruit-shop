package core.basesyntax.service.strategy;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;

public class PurchaseHandler implements OperationHandler {
    private StorageService storageService = new StorageServiceImpl();
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageService.get(new Fruit(fruitTransaction.getFruit()), fruitTransaction.getQuantity());
        int remnant = storageDao.getFromStorage()
                .get(new Fruit(fruitTransaction.getFruit())) - fruitTransaction.getQuantity();
        storageService.updateStorage(new Fruit(fruitTransaction.getFruit()), remnant);
    }
}
