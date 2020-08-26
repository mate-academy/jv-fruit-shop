package core.basesyntax.service;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.TreeMapStorage;

import java.time.LocalDate;
import java.util.Map;

public class SupplyService implements Handleable {
    @Override
    public void operationWithProduct(Fruit fruit) {
        LocalDate fruitDate = fruit.getDate();
        String fruitName = fruit.getName();

        Fruit newFruit = fruit;
        for (Map.Entry<LocalDate, Fruit> entry : TreeMapStorage.treeMapStorage.entrySet()) {
            if (entry.getKey().isEqual(fruitDate)
                    && entry.getValue().getName().equals(fruitName)) {
                newFruit.setAmount(fruit.getAmount() + entry.getValue().getAmount());
                entry.setValue(newFruit);
            }
        }
        TreeMapStorage.treeMapStorage.put(fruitDate, fruit);
    }
}
