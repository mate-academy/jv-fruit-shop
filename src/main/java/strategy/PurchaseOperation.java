package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements Operating {
    private static final Storage storage = new Storage();

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer transactionAmount = fruitTransaction.getQuantity();
        Integer storageAmount = storage.getFruitsNumber(fruit);
        if (storageAmount >= transactionAmount) {
            storage.storeFruit(fruit, storageAmount - transactionAmount);
        } else {
            throw new RuntimeException("Insufficient quantity in storage for " + fruit);
        }
    }
}
