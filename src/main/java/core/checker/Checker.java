package core.checker;

import core.db.Storage;

public class Checker {
    private final Storage storage;
    
    public Checker(Storage storage) {
        this.storage = storage;
    }
    
    public void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
    }
    
    public void validateFruit(String fruit) {
        if (!storage.contains(fruit)) {
            throw new RuntimeException("Cannot find fruit: " + fruit);
        }
    }
    
    public void validateNewEntry(String fruit, int quantity) {
        if (fruit == null || fruit.isEmpty()) {
            throw new IllegalArgumentException("Fruit must not be null or empty.");
        }
        validateQuantity(quantity);
    }
}
