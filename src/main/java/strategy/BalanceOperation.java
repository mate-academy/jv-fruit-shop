package strategy;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperation implements FruitOperation {
    private FruitTransaction fruitTransaction;
    private Storage storage;

    public BalanceOperation(FruitTransaction fruitTransaction, Storage storage) {
        this.fruitTransaction = fruitTransaction;
        this.storage = storage;
    }

    @Override
    public void execute(Storage storage, FruitTransaction fruitTransaction) {
        storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
