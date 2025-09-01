package core.basesyntax.fruittransactionhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {

    private Storage storageService;

    public PurchaseHandler(Storage storageService) {
        this.storageService = storageService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldValue = storageService.getDataStorageMapOrDefault(fruitTransaction
                .getFruit()).get(fruitTransaction.getFruit());
        if (oldValue - fruitTransaction.getQuantity() >= 0) {
            storageService.getDataStorageMapOrDefault(fruitTransaction.getFruit())
                    .put(fruitTransaction.getFruit(), oldValue - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("The result of purchase operation is negative.");
        }
    }
}
