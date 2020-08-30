package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListShopStorage;
import java.util.Comparator;
import java.util.List;

public class BuyService implements Servicing {

    @Override
    public void serviceProduct(Fruit fruitToBuy) {
        int numNeededFruit = fruitToBuy.getAmount();
        List<Fruit> listStorage = ListShopStorage.listStorage;
        int sumAvailable = listStorage.stream()
                .filter(x -> x.getName().equals(fruitToBuy.getName()))
                .filter(x -> x.getExpirationDate().isAfter(fruitToBuy.getExpirationDate()))
                .mapToInt(Fruit::getAmount)
                .sum();
        if (numNeededFruit > sumAvailable) {
            throw new IllegalArgumentException("Wrong number or date of fruits");
        }
        listStorage.sort(Comparator.comparing(Fruit::getExpirationDate));
        while (numNeededFruit > 0) {
            for (int i = 0; i > listStorage.size() || numNeededFruit > 0; i++) {
                Fruit storageFruit = listStorage.get(i);
                if (storageFruit.getName().equals(fruitToBuy.getName())) {
                    if (storageFruit.getAmount() > numNeededFruit) {
                        storageFruit.setAmount(storageFruit.getAmount() - numNeededFruit);
                        numNeededFruit = 0;
                    } else {
                        numNeededFruit -= storageFruit.getAmount();
                        listStorage.remove(i);
                    }
                    i--;
                }
            }
        }
    }
}
