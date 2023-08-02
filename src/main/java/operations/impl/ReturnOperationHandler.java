package operations.impl;

import db.*;
import model.*;
import operations.*;

import java.awt.desktop.*;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void execute(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruitName();
        int quantity = fruitTransaction.getQuantity();
        int newBalance = storage.getFruitBalance(fruit) + quantity;
        storage.addFruits(fruit,newBalance);
    }
}
