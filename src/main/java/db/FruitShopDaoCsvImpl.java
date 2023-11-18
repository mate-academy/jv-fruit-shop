package db;

import model.FruitTransaction;
import storage.Storage;
import strategy.FruitStrategy;

import java.util.Collections;
import java.util.Map;

public class FruitShopDaoCsvImpl implements FruitShopDao {
    private FruitStrategy fruitStrategy;

    public FruitShopDaoCsvImpl(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
            fruitStrategy.getOperationHandler(fruitTransaction.getOperation())
                    .handleOperation(fruitTransaction);
            return;
        }
        update(fruitTransaction);
    }

    @Override
    public Map<String, Integer> getAllFruitsAndQuantities() {
        return Collections.unmodifiableMap(Storage.fruitQuantities);
    }

    @Override
    public void update(FruitTransaction fruitTransaction) {
        fruitStrategy.getOperationHandler(fruitTransaction.getOperation())
                .handleOperation(fruitTransaction);
    }
}
