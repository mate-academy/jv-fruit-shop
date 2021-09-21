package myFruitShop.Service.Operations;

import myFruitShop.FruitStorage.FruitStorage;
import myFruitShop.model.Fruit;
import myFruitShop.model.OperationsDto;

import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void applyOperation(OperationsDto data) {
        Map<Fruit,Integer> fruitStorage = FruitStorage.getStorage();
        Fruit fruit = data.getFruitType();
        Integer fruitsDemand = data.getAmount();
        if (fruitStorage.containsKey(fruit)) {                                     //if we have such fruit to buy, we do
            Integer fruitLeftForSale = fruitStorage.get(fruit);                    // old amount of fruit
           Integer fruitsAfterPurchase = fruitLeftForSale - fruitsDemand;            // new amount
           if (fruitsAfterPurchase < 0) {
               throw new RuntimeException("not enough fruits in the shop!");
           }
           fruitStorage.replace(fruit, fruitLeftForSale, fruitsAfterPurchase);       //change value in map
        } else {
            throw new RuntimeException("not enough fruits in the shop!");
        }
    }
}
