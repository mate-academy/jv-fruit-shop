package myFruitShop.Service.Operations;

import myFruitShop.FruitStorage.FruitStorage;
import myFruitShop.model.Fruit;
import myFruitShop.model.TransactionDto;

import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void applyOperation(TransactionDto data) {
        Map<Fruit,Integer> fruitStorage = FruitStorage.getStorage();
        Fruit fruit = data.getFruitType();
        int amountOfReturnedFruits = data.getAmount();
        if (fruitStorage.containsKey(fruit)) {
            Integer amountAfterReturn = fruitStorage.get(fruit) + amountOfReturnedFruits;
            fruitStorage.replace(fruit, fruitStorage.get(fruit), amountAfterReturn);
        } else {
            fruitStorage.put(fruit, amountOfReturnedFruits);
        }
    }
}
