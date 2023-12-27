package strategy;

import db.Storage;
import model.FruitTransaction;

public class SupplyReturnOperation implements FruitOperation {
    private FruitTransaction fruitTransaction;
    private Storage storage;

    public SupplyReturnOperation(FruitTransaction fruitTransaction, Storage storage) {
        this.fruitTransaction = fruitTransaction;
        this.storage = storage;
    }

    @Override
    public void execute(Storage storage, FruitTransaction fruitTransaction) {
        Integer currentQuantity = storage.get(fruitTransaction.getFruit());
        int storageValue = (currentQuantity != null) ? currentQuantity : 0;
        storage.put(fruitTransaction.getFruit(),
                storageValue + fruitTransaction.getQuantity());
    }
}
