package operations.impl;

import db.*;
import model.*;
import operations.*;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void execute(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruitName();
        int quantity = fruitTransaction.getQuantity();
        storage.addFruits(fruit,quantity);

    }

}
