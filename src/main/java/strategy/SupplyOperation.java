package strategy;

import db.Storage;
import model.FruitTransaction;

public class SupplyOperation implements Operating {
    private static final Storage storage = new Storage();

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer transactionAmount = fruitTransaction.getQuantity();
        Integer storageAmount = storage.getFruitsNumber(fruit);
        storage.storeFruit(fruit, storageAmount + transactionAmount);
    }
}
