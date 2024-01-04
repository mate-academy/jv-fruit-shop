package strategy;

import dao.Storage;
import model.FruitTransaction;

public class SupplyReturnOperation implements ExecuteFruitOperation {
    private final Storage storage;

    public SupplyReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        storage.merge(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(), Integer::sum);
    }
}
