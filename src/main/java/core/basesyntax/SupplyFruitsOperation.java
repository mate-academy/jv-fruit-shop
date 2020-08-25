package core.basesyntax;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class SupplyFruitsOperation implements StoreOperations {

    @Override
    public void action(List<Fruit> fruitList, String name, LocalDate date, Integer quantity) {
        Fruit finderFruit;
        if (fruitList.isEmpty()
                || (finderFruit = finderNecessaryFruitStorage(fruitList, name)) == null) {
            addNewFruitToList(date, quantity, name, fruitList);
            return;
        }
        Map<LocalDate, Integer> storage = finderFruit.getStorage();
        storage.merge(date, quantity, (a, b) -> a + b);
    }

    private Fruit finderNecessaryFruitStorage(List<Fruit> list, String name) {
        for (Fruit fruit : list) {
            if (fruit.getName().equals(name)) {
                return fruit;
            }
        }
        return null;
    }

    private void addNewFruitToList(LocalDate date, Integer amountOfFruit,
                                   String fruitName, List<Fruit> fruits) {
        Fruit fruit = new Fruit(fruitName);
        fruit.getStorage().put(date, amountOfFruit);
        fruits.add(fruit);
    }
}

