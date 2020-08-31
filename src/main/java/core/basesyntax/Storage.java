package core.basesyntax;

import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.StoreOperation;
import core.basesyntax.operations.SupplyOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    public Map<String, Integer> getFruitsQuantityByType() {
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
        return fruitsQuantity;
    }

    public void fillStorage(List<Transaction> transactions) {
        Map<String, StoreOperation> storeOperationMap = new HashMap<>();
        storeOperationMap.put("s", new SupplyOperation(this));
        storeOperationMap.put("b", new BuyOperation(this));
        storeOperationMap.put("r", new ReturnOperation(this));

        for (Transaction transaction : transactions) {
            storeOperationMap.get(transaction.getOperation()).performOperation(transaction);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Storage storage1 = (Storage) o;
        return Objects.equals(storage, storage1.storage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storage);
    }
}
