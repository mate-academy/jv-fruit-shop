package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;
import java.util.Comparator;

public class BuyService implements ServiceAble {

    @Override
    public void operationWithProduct(Fruit fruit) {
        int numNeededFruit = fruit.getAmount();

        int sumAvailable = ListStorage.listStorage.stream()
                .filter(x -> x.getName().equals(fruit.getName()))
                .filter(x -> x.getExpirationDate().isAfter(fruit.getExpirationDate()))
                .mapToInt(Fruit::getAmount)
                .sum();
        if (numNeededFruit > sumAvailable) {
            throw new IllegalArgumentException("Wrong number or date of fruits");
        }
        ListStorage.listStorage.sort(Comparator.comparing(Fruit::getExpirationDate));
        for (int i = 0; i < numNeededFruit; i++) {
            ListStorage.listStorage.remove(0);
        }
    }
}
