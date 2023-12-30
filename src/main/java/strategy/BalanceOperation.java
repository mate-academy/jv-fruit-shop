package strategy;

import dao.Storage;
import model.FruitTransaction;

public class BalanceOperation implements FruitOperation {
    private Storage storage;

    public BalanceOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void execute(Storage storage, FruitTransaction fruitTransaction) {
        storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
