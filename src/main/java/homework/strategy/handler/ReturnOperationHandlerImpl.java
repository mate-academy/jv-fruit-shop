package homework.strategy.handler;

import static homework.storage.Storage.dataBase;

import homework.model.Fruit;
import homework.model.FruitTransaction;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        dataBase.put(fruit, fruitTransaction.getQuantity() + dataBase.get(fruit));
    }
}
