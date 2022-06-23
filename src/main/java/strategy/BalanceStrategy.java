package strategy;

import static db.Storage.fruitStorage;

import service.Strategy;

public class BalanceStrategy implements Strategy {

    @Override
    public boolean updateStorage(String fruitName, int quantity) {
        if (fruitStorage.containsKey(fruitName)) {
            throw new RuntimeException(fruitName + " already exists in the storage");
        }
        fruitStorage.put(fruitName, quantity);
        return true;
    }
}
