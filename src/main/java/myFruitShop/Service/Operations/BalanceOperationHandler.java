package myFruitShop.Service.Operations;

import myFruitShop.FruitStorage.FruitStorage;
import myFruitShop.model.Fruit;
import myFruitShop.model.OperationsDto;

import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void applyOperation(OperationsDto data) {
       Map<Fruit, Integer> fruitStorage = FruitStorage.getStorage();          //we take our storage

       if (fruitStorage.containsKey(data.getFruitType()) && fruitStorage.get(data.getFruitType()) != 0) {  //if we had some info about that fruit before balance
           throw new RuntimeException("Balance already has been calculated today, check input data!");
       }
       fruitStorage.put(data.getFruitType(), data.getAmount());              // we put balance value of some fruit down there
    }
}
