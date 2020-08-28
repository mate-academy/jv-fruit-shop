package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;
import java.util.Comparator;
import java.util.List;

public class BuyService implements ServiceAble {

    @Override
    public void operationWithProduct(Fruit fruit) {
        int numNeededFruit = fruit.getAmount();
        List<Fruit> listStorage = ListStorage.listStorage;
        int sumAvailable = listStorage.stream()
                .filter(x -> x.getName().equals(fruit.getName()))
                .filter(x -> x.getExpirationDate().isAfter(fruit.getExpirationDate()))
                .mapToInt(Fruit::getAmount)
                .sum();
        if (numNeededFruit > sumAvailable) {
            throw new IllegalArgumentException("Wrong number or date of fruits");
        }
        listStorage.sort(Comparator.comparing(Fruit::getExpirationDate));
        while (numNeededFruit > 0) {
            for (int i = 0; i > listStorage.size() || numNeededFruit > 0; i++) {
                if (listStorage.get(i).getName().equals(fruit.getName())) {
                    listStorage.remove(i);
                    numNeededFruit--;
                    i--;
                }
            }
        }
    }
}
