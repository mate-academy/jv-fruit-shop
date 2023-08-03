package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ShopServiceImpl implements ShopService {
    private FruitTransaction fruitTransaction;
    private OperationStrategy operationStrategy;

    public ShopServiceImpl() {
    }

    public ShopServiceImpl(FruitTransaction fruitTransaction, OperationStrategy operationStrategy) {
        this.fruitTransaction = fruitTransaction;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void supplyFruit(FruitTransaction transaction) {
        int currentValue = Storage.getReport().get(transaction.getFruit());
        if (Storage.getReport().containsKey(transaction.getFruit())) {
            Storage.getReport().put(transaction.getFruit(),
                    currentValue + transaction.getQuantity());
        }
        Storage.getReport().put(transaction.getFruit(), transaction.getQuantity());
    }

    @Override
    public void purchaseFruit(FruitTransaction transaction) {
        int currentValue = Storage.getReport().get(transaction.getFruit());
        if (Storage.getReport().containsKey(transaction.getFruit())) {
            if (currentValue < transaction.getQuantity()) {
                throw new RuntimeException("We don't have than much fruit to sell");
            }
        }
        Storage.getReport().put(transaction.getFruit(), currentValue - transaction.getQuantity());
    }

    @Override
    public void returnFruit(FruitTransaction transaction) {
        int currentValue = Storage.getReport().get(transaction.getFruit());
        Storage.getReport().put(transaction.getFruit(), currentValue + transaction.getQuantity());
    }

    @Override
    public int balanceOfFruit(FruitTransaction transaction) {
        if (Storage.getReport().get(transaction.getFruit()) == 0) {
            throw new RuntimeException("We don't have that fruit");
        }
        return Storage.getReport().get(transaction.getFruit());
    }
}
