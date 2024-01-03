package strategy;

import dao.Storage;
import model.FruitTransaction;

public class FruitOperationImpl implements FruitOperation {
    private static final int ZERO_VALUE = 0;
    private final Storage storage;

    public FruitOperationImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        Integer currentQuantity = storage.get(fruitTransaction.getFruit());
        int storageValue = (currentQuantity != null) ? currentQuantity : ZERO_VALUE;
        storage.put(fruitTransaction.getFruit(),
                storageValue - fruitTransaction.getQuantity());
    }
}
