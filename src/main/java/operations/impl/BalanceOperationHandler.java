package operations.impl;

import db.*;
import model.*;
import operations.*;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void execute(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruitName();
        int balance = storage.getFruitBalance(fruit);
    }
}
