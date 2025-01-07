package strategy.impl;

import static db.Storage.modifyFruitStock;

import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction transaction) {
        modifyFruitStock(transaction.getFruit(), transaction.getQuantity());
    }
}
