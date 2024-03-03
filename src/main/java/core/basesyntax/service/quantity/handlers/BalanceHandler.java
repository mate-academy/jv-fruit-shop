package core.basesyntax.service.quantity.handlers;

import core.basesyntax.entity.FruitTransaction;

import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction, Map<String,Integer> fruitMap) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        fruitMap.put(fruit,quantity);
    }
}
