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
        String fruitName = fruitBox.getFruitType();
        int amount = fruitBox.getQuantity();
        if (storage.containsKey(fruitName)) {
            if (totalAmount >= amount) {
                for (FruitBox existingBox : storage.values()) {
                    if (existingBox.getFruitType().equals(fruitName) && !existingBox.isEmpty()
                            && existingBox.getDate().isAfter(fruitBox.getDate())) {
                        int numberOfFruits = existingBox.getQuantity();
                        if (amount <= numberOfFruits) {
                            existingBox.setQuantity(numberOfFruits - amount);
                        } else {
                            amount -= numberOfFruits;
                            existingBox.setQuantity(0);
                        }
                    }
                }
                return storage;
            }
            throw new RuntimeException("Storage does not contain such amount of fruit");
        }
        throw new RuntimeException("The fruit does not exist");
    }
}
