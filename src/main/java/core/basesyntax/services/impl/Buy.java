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

        int summ = list.stream()
                .mapToInt(Fruit::getStock_balance)
                .sum();

        if (summ < fruit.getStock_balance()) {
            throw new RuntimeException("Not enough items in stock");
        }

        list.forEach(fruit1 -> {
            if (fruit1.getStock_balance() >= fruit.getStock_balance()) {
                fruit1.setStock_balance(fruit1.getStock_balance() - fruit.getStock_balance());
                fruit.setStock_balance(0);
            }
            if (fruit1.getStock_balance() < fruit.getStock_balance()) {
                fruit.setStock_balance(fruit.getStock_balance() - fruit1.getStock_balance());
                fruit1.setStock_balance(0);
            }
        });
    }
}
