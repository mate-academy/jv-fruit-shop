package core.basesyntax.services.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.services.ActionInterface;

public class Buy implements ActionInterface {

    @Override
    public void action(Storage storage, Fruit fruit) {
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
