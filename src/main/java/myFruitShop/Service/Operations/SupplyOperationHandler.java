package myFruitShop.Service.Operations;

import myFruitShop.FruitStorage.FruitStorage;
import myFruitShop.model.Fruit;
import myFruitShop.model.TransactionDto;

import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void applyOperation(TransactionDto data) {
        Map<Fruit,Integer> fruitStorage = FruitStorage.getStorage();
        Fruit fruit = data.getFruitType();
        int supplyAmount = data.getAmount();
        if (fruitStorage.containsKey(fruit)) {
            Integer amountBeforSupply = fruitStorage.get(fruit);
            Integer amountAfterSupply = amountBeforSupply + supplyAmount;
            fruitStorage.replace(fruit, amountAfterSupply, amountAfterSupply);
        } else {
            fruitStorage.put(fruit, supplyAmount);
        }
    }
}
