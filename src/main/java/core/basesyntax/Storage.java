package core.basesyntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        while (counter <= quantity && fruitIterator.hasNext()) {
            storage.remove(fruitIterator.next());
        }
    }

    public String getFruitsQuantity() {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> fruitsQuantity = new HashMap<>();
        
        String[] kindOfFruits = (String[]) storage.stream()
                .map(Fruit::getFruitName)
                .distinct()
                .toArray();
        
        for (int i = 0; i < kindOfFruits.length; i++) {
            String fruit = kindOfFruits[i];
            int fruitQuantity = (int) storage.stream()
                    .filter(f -> f.getFruitName().equals(fruit))
                    .count();
            fruitsQuantity.put(kindOfFruits[i], fruitQuantity);            
        }
        result.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry: fruitsQuantity.entrySet()) {
            result.append("\n").append(entry.getKey()).append(",").append(entry.getValue());
        }

        return result.toString();
    }
}
