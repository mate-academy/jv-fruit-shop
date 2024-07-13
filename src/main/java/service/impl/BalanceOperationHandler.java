package service.impl;

import java.util.Map;
import model.FruitTransaction;
import service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
