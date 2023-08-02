package operations.impl;

import db.*;
import model.*;
import operations.*;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void execute(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruitName();
        int quantity = fruitTransaction.getQuantity();
        int balance = storage.getFruitBalance(fruit);
        if (balance < quantity) {
            throw new RuntimeException("Insufficient quantity of " + fruit + " in the store for purchase.");
        }

        storage.removeFruit(fruit,quantity);
    }
}
