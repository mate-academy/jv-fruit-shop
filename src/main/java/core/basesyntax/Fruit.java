package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Fruit {
    Map<String,Integer> fruitMap;

    public Fruit() {
        this.fruitMap = new HashMap<>();
    }

    public int getCurrentAmount(String fruitType) {
        return fruitMap.getOrDefault(fruitType, 0);
    }

   public int balance(String fruitType, int amount) {
        fruitMap.put(fruitType,amount);
        return amount;
   }
   public int supply(String fruitType, int amount) {
       int newAmount = fruitMap.get(fruitType) + amount;
       fruitMap.put(fruitType,newAmount);
        return newAmount;
   }
   public int returnFruit(String fruitType, int amount) {
        int returnedAmount = fruitMap.getOrDefault(fruitType, 0) + amount;
        fruitMap.put(fruitType, returnedAmount);
        return returnedAmount;
   }
   public int purchase(String fruitType, int amount) {
        int purchaseAmount = fruitMap.getOrDefault(fruitType, 0);
        if (purchaseAmount < amount) {
            throw new IllegalStateException("Not enough fruits");
        }
        int newAmount = fruitMap.get(fruitType)- amount;
        fruitMap.put(fruitType,newAmount);
        return newAmount;
   }
}
