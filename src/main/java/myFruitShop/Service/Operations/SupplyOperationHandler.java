package myFruitShop.Service.Operations;

import myFruitShop.FruitStorage.FruitStorage;
import myFruitShop.model.Fruit;
import myFruitShop.model.OperationsDto;

import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void applyOperation(OperationsDto data) {
        Map<Fruit,Integer> fruitStorage = FruitStorage.getStorage();
        Fruit fruit = data.getFruitType();
        int supplyAmount = data.getAmount();
        if (fruitStorage.containsKey(fruit)) {
            Integer amountBeforeSupply = fruitStorage.get(fruit);
            Integer amountAfterSupply = amountBeforeSupply + supplyAmount;
            fruitStorage.replace(fruit, amountBeforeSupply, amountAfterSupply);
        } else {
            fruitStorage.put(fruit, supplyAmount);
        }
    }
}
