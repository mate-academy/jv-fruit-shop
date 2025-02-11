package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageServiceImp implements StorageService {
    private final Map<String, Integer> fruitMap = new HashMap<>();

    @Override
    public void add(String fruit, int quantity) {
        if (fruit != null) {
            fruitMap.put(fruit, fruitMap.getOrDefault(fruit, 0) + quantity);
        }
    }

    @Override
    public void remove(String fruit, int quantity) {
        if (fruit == null || !fruitMap.containsKey(fruit)) {
            throw new RuntimeException("Fruit not found in storage: " + fruit);
        }
        int currentQuantity = fruitMap.get(fruit);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in storage to remove " + quantity);
        }
        fruitMap.put(fruit, currentQuantity - quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return fruitMap.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getAll() {
        return new HashMap<>(fruitMap);
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            switch (transaction.getOperation()) {
                case BALANCE:
                case SUPPLY:
                    add(transaction.getFruit(), transaction.getQuantity());
                    break;
                case PURCHASE:
                case RETURN:
                    remove(transaction.getFruit(), transaction.getQuantity());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operation: "
                            + transaction.getOperation());
            }
        }
    }
}
