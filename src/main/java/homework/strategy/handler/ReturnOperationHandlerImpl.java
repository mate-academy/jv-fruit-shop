package homework.strategy.handler;

import static homework.storage.Storage.dataBase;

import homework.service.impl.FruitTransaction;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        dataBase.put(fruit, fruitTransaction.getQuantity() + dataBase.get(fruit));
    }
}
