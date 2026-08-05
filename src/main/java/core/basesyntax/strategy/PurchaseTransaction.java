package core.basesyntax.strategy;

import static core.basesyntax.db.Storage.getFruits;

import core.basesyntax.model.Fruit;

public class PurchaseTransaction implements Transaction {

    @Override
    public void process(String fruitName, int amount) {
        int storageAmount = getFruits().stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst()
                .map(Fruit::getQuantity)
                .orElse(0);
        if (storageAmount - amount >= 0) {
            getFruits().stream().filter(fruit -> fruit.getName().equals(fruitName))
                    .findFirst()
                    .ifPresent(fruit -> fruit.setQuantity(storageAmount - amount));
        } else {
            throw new RuntimeException("Not enough fruits in storage");
        }
    }
}
