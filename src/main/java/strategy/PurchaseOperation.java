package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements Operating {
    public PurchaseOperation() {
    }

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer transactionAmount = fruitTransaction.getQuantity();
        Integer storageAmount = Storage.getFruitsNumber(fruit);
        Storage.storeFruit(fruit, storageAmount - transactionAmount);
    }
}
