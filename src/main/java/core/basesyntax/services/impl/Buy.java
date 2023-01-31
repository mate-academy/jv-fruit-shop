package core.basesyntax.services.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.services.ActionInterface;
import java.util.List;
import java.util.stream.Collectors;

public class Buy implements ActionInterface {
    private Storage storage;

    public Buy(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void action(Fruit fruit) {
        List<Fruit> list = storage.getFruits().stream()
                .filter(storageFruit -> storageFruit.getType().equals(fruit.getType()))
                .filter(storagefruit -> storagefruit.getDate().isAfter(fruit.getDate())
                        || storagefruit.getDate().isEqual(fruit.getDate()))
                .sorted()
                .collect(Collectors.toList());

        int sum = list.stream()
                .mapToInt(Fruit::getStockBalance)
                .sum();

        if (sum < fruit.getStockBalance()) {
            throw new RuntimeException("Not enough items in stock");
        }

        list.forEach(fruit1 -> {
            toBuyLogic(fruit1, fruit);
        });
    }

    private void toBuyLogic(Fruit fruit, Fruit fruitBuy) {
        if (fruit.getStockBalance() >= fruitBuy.getStockBalance()) {
            fruit.setStock_balance(fruit.getStockBalance() - fruitBuy.getStockBalance());
            fruitBuy.setStock_balance(0);
        }
        if (fruit.getStockBalance() < fruitBuy.getStockBalance()) {
            fruitBuy.setStock_balance(fruitBuy.getStockBalance() - fruit.getStockBalance());
            fruit.setStock_balance(0);
        }
    }
}
