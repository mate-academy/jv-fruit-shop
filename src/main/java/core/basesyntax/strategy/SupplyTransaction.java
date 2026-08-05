package core.basesyntax.strategy;

import static core.basesyntax.db.Storage.getFruits;

public class SupplyTransaction implements Transaction {

    @Override
    public void process(String fruitName, int amount) {
        getFruits().stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst()
                .ifPresent(fruit -> fruit.setQuantity(fruit.getQuantity() + amount));
    }
}
