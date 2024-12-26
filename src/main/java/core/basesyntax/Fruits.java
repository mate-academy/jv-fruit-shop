package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public abstract class Fruits {
    private Map<String, Integer> fruitQuantities;

    public int getFruitQuantities(String fruitType) {
        return fruitQuantities.get(fruitType);
    }

    public void setFruitQuantities(String fruitType, int quantity) {
        fruitQuantities.put(fruitType, quantity);
    }

    // Конструктор
    public Fruits() {
        fruitQuantities = new HashMap<>();
    }

    public int balance(String fruitType,int init) {
        fruitQuantities.put(fruitType,init);
        return init;
    }
    public int supply(String fruitType,int quantityOfFruits) {
        int supplyAmount = fruitQuantities.get(fruitType) + quantityOfFruits;
        fruitQuantities.put(fruitType,supplyAmount);
        return supplyAmount;
    }
    public int purchase(String fruiType,int amount) {
        int purchaseAmount = fruitQuantities.get(fruiType) - amount;
        fruitQuantities.put(fruiType,purchaseAmount);
        return purchaseAmount;
    }
    public int returnFruit(String fruitType,int amount) {
        int returnedAmount = fruitQuantities.get(fruitType) + amount;
        fruitQuantities.put(fruitType,returnedAmount);
        return returnedAmount;
    }
}
