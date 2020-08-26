package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.TreeMapStorage;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.IntStream;

public class BuyService implements Handleable {

    @Override
    public void operationWithProduct(Fruit fruit) {
        int numNeededFruit = fruit.getAmount();
        String key = fruit.getName();
        int count = TreeMapStorage.treeMapStorage
                .entrySet()
                .stream()
                .filter(x -> x.getValue().getName().equals(key))
                .filter(x -> x.getValue().getDate().isAfter(fruit.getDate()))
                .flatMapToInt(x -> IntStream.of(x.getValue().getAmount()))
                .sum();
        if (count > numNeededFruit) {
            for (Map.Entry<LocalDate, Fruit> entry : TreeMapStorage.treeMapStorage.entrySet()) {
                if (entry.getKey().isAfter(fruit.getDate()) && entry.getValue().getName().equals(fruit.getName())) {
                    int amount = entry.getValue().getAmount();
                    if (amount >= numNeededFruit) {
                        entry.getValue().setAmount(amount - numNeededFruit);
                        return;
                    }
                    numNeededFruit -= amount;
                    entry.getValue().setAmount(0);
                }
            }
        } else {
//            throw new NumberFormatException("Not enough fruit for this " + fruit.getDate() + " date!");
        }
    }
}
