package strategy;

import static db.Storage.fruitStorage;

import service.Strategy;

public class PurchaseStrategy implements Strategy {

    @Override
    public boolean updateStorage(String fruitName, int quantity) {
        if (!fruitStorage.containsKey(fruitName)) {
            throw new RuntimeException(fruitName + " doesn't exist in the storage");
        }
        int currentQuantity = fruitStorage.get(fruitName);
        if (currentQuantity < quantity) {
            throw new RuntimeException(quantity + " " + fruitName + "s is not available");
        }
        fruitStorage.put(fruitName, currentQuantity - quantity);
        return true;
    }
}
