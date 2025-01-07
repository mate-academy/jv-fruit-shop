package strategy.impl;

import static db.Storage.getFruitStock;
import static db.Storage.modifyFruitStock;

import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction transaction) {
        int currentQuantity = getFruitStock().getOrDefault(transaction.getFruit(), 0);
        modifyFruitStock(transaction.getFruit(),
                currentQuantity + transaction.getQuantity());
    }
}
