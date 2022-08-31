package strategy.handler;

import static storage.Storage.dataBase;

import model.Fruit;
import model.FruitTransaction;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        dataBase.put(fruit, fruitTransaction.getQuantity() + dataBase.get(fruit));
    }
}
