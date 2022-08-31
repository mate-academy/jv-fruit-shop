package strategy.handler;

import static storage.Storage.dataBase;

import model.Fruit;
import model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        int fruitNeed = fruitTransaction.getQuantity();
        int fruitLeft = dataBase.get(fruit);
        if (fruitLeft < fruitNeed) {
            throw new RuntimeException("Not enough: " + fruit
                    + ". Remain: " + fruitLeft
                    + ". Need: " + fruitNeed + ".");
        }
        dataBase.put(fruit, fruitLeft - fruitNeed);
    }
}
