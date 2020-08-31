package core.basesyntax;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FruitStorage {
    private List<Fruit> fruits = new ArrayList<>();

    public void add(Fruit fruit) {
        fruits.add(fruit);
    }

    public void remove(Fruit fruitToDelete) {
        fruits.sort(Comparator.comparing(Fruit::getDate));
        Optional<Fruit> itemToDelete = fruits.stream()
                .filter(fruit -> fruit.getName().equals(fruitToDelete.getName()))
                .findFirst();
        fruits.remove(itemToDelete.orElseThrow());
    }

    public List<Fruit> getListOfFruits() {
        return fruits;
    }

    public List<String> getReport() {
        List<String> list = new ArrayList<>();
        String line;
        Set<String> names = fruits.stream()
                .map(Fruit::getName)
                .collect(Collectors.toSet());
        for (String name : names) {
            long fruitsAmount = fruits.stream()
                    .filter(fruit -> fruit.getName().equals(name))
                    .count();
            line = name + "," + fruitsAmount;
            list.add(line);
        }
        return list;
    }

    public int size() {
        return fruits.size();
    }
}
