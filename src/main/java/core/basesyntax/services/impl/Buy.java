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

        System.out.println(list);

        int summ = list.stream()
                .mapToInt(Fruit::getStock_balance)
                .sum();

        System.out.println(summ);

        //Посчитать доступные бананы
        //int summ = list.stream().map((fruit1 -> fruit.getStock_balance())).reduce(I)

       // System.out.println(summ);
        for (Fruit fr: list) {

        }


        if (storage.getFruits().contains(fruit)) {
            int numInStorage = storage.getFruits().indexOf(fruit);
            int newCount = storage.getFruits().get(numInStorage).getStock_balance() - fruit.getStock_balance();
            if (newCount < 0) {
                throw new RuntimeException("Недостаточно товаров на складе");
            }
            if (fruit.getDate().isAfter(storage.getFruits().get(numInStorage).getDate())) {
                throw new RuntimeException("Нет товаров с пригодным сроком");
            }
            storage.getFruits().get(numInStorage).setStock_balance(newCount);
        }
    }
}
