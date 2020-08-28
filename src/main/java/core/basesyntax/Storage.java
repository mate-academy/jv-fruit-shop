package core.basesyntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    private final List<Fruit> storage = new ArrayList<>();

    public List<Fruit> getStorage() {
        return storage;
    }

    public void addFruit(Fruit fruit) {
        storage.add(fruit);
    }

    public void removeFruits(String fruitName, int quantity) {
        Iterator<Fruit> fruitIterator = storage.iterator();
        int counter = 0;
        while (counter < quantity && fruitIterator.hasNext()) {
            if (fruitIterator.next().getFruitName().equals(fruitName)) {
                fruitIterator.remove();
                counter++;
            }
        }
    }

    public String getFruitsQuantity() {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> fruitsQuantity = new HashMap<>();
        
        List<String> kindOfFruits = storage.stream()
                .map(Fruit::getFruitName)
                .distinct()
                .collect(Collectors.toList());
        
        for (int i = 0; i < kindOfFruits.size(); i++) {
            String fruit = kindOfFruits.get(i);
            int fruitQuantity = (int) storage.stream()
                    .filter(f -> f.getFruitName().equals(fruit))
                    .count();
            fruitsQuantity.put(kindOfFruits.get(i), fruitQuantity);
        }
        result.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry: fruitsQuantity.entrySet()) {
            result.append("\n").append(entry.getKey()).append(",").append(entry.getValue());
        }
        return result.toString();
    }
}
