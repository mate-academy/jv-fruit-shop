package strategy;

import dao.Storage;
import model.FruitTransaction;

public class BalanceOperation implements ExecuteFruitOperation {
    private final Storage storage;

    public BalanceOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
