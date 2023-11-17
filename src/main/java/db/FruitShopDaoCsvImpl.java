package db;

import model.FruitTransaction;
import storage.Storage;
import strategy.FruitStrategy;
import strategy.OperationHandler;

import java.math.BigDecimal;

public class FruitShopDaoCsvImpl implements FruitShopDao {
    private FruitStrategy fruitStrategy;

    public FruitShopDaoCsvImpl(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
            Storage.fruitQuantities.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
            return;
        }
        update(fruitTransaction);
    }

    @Override
    public void update(FruitTransaction fruitTransaction) {
        fruitStrategy.getOperationHandler(fruitTransaction.getOperation()).handleOperation(fruitTransaction);
    }
}
