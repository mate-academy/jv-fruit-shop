package homework.strategy.handler;

import static homework.storage.Storage.dataBase;

import homework.model.Fruit;
import homework.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        int fruitNeed = fruitTransaction.getQuantity();
        int fruitLeft = dataBase.get(fruit);
        if (fruitLeft < fruitNeed) {
            throw new RuntimeException("Not enought " + fruit
                    + ". Remain: " + dataBase.get(fruit)
                    + ". Need: " + fruitNeed + ".");
        }
        dataBase.put(fruit, fruitLeft - fruitNeed);
    }
}
