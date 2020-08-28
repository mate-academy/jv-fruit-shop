package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.util.Map;

public class Buy extends Operation {
    public Buy(OperationType type, FruitBox fruit) {
        super(type, fruit);
    }

    @Override
    public Map<String, FruitBox> changeQuantity(int totalAmount,
                                                Map<String, FruitBox> storage) {
        String fruitName = fruit.getFruitType();
        int amount = fruit.getQuantity();
        if (!storage.containsKey(fruitName)) {
            throw new RuntimeException("The fruit does not exist");
        }
        if (totalAmount >= amount) {
            for (FruitBox fruitBox : storage.values()) {
                if (fruitBox.getFruitType().equals(fruitName) && !fruitBox.isEmpty()
                        && fruitBox.getDate().isAfter(fruit.getDate())) {
                    int numberOfFruits = fruitBox.getQuantity();
                    if (amount <= numberOfFruits) {
                        fruitBox.setQuantity(numberOfFruits - amount);
                    } else {
                        amount -= numberOfFruits;
                        fruitBox.setQuantity(0);
                    }
                }
            }
            return storage;
        }
        throw new RuntimeException("Storage does not contain such amount of fruit");
    }
}
