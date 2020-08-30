package core.basesyntax.services.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.services.ActionInterface;
import java.util.List;
import java.util.stream.Collectors;

public class Buy implements ActionInterface {

    @Override
    public void action(Storage storage, Fruit fruit) {
        List<Fruit> list = storage.getFruits().stream()
                .filter(storageFruit -> storageFruit.getType().equals(fruit.getType()))
                .filter(storagefruit -> storagefruit.getDate().isAfter(fruit.getDate())
                        || storagefruit.getDate().isEqual(fruit.getDate()))
                .sorted()
                .collect(Collectors.toList());

        int sum = list.stream()
                .mapToInt(Fruit::getStock_balance)
                .sum();

        if (sum < fruit.getStock_balance()) {
            throw new RuntimeException("Not enough items in stock");
        }

        list.forEach(fruit1 -> {
            toBuyLogic(fruit1, fruit);
        });
    }

    private void toBuyLogic(Fruit fruit, Fruit fruitBuy) {
        if (fruit.getStock_balance() >= fruitBuy.getStock_balance()) {
            fruit.setStock_balance(fruit.getStock_balance() - fruitBuy.getStock_balance());
            fruitBuy.setStock_balance(0);
        }
        if (fruit.getStock_balance() < fruitBuy.getStock_balance()) {
            fruitBuy.setStock_balance(fruitBuy.getStock_balance() - fruit.getStock_balance());
            fruit.setStock_balance(0);
        }
    }
}
