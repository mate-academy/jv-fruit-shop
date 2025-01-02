package core.basesyntax.model;

import core.basesyntax.storage.Storage;

public class Fruit {
    private Storage storage;

    public Fruit() {
        storage = new Storage();
    }

    /*public int balance(String fruitType, int amount) {
        storage.put(fruitType,amount);
        return amount;
    }

    public int supply(String fruitType, int amount) {
        int newAmount = storage.get(fruitType) + amount;
        storage.put(fruitType,newAmount);
        return newAmount;
    }

    public int returnFruit(String fruitType, int amount) {
        int returnedAmount = storage.getOrDefault(fruitType, 0) + amount;
        storage.put(fruitType, returnedAmount);
        return returnedAmount;
    }

    public int purchase(String fruitType, int amount) {
        int purchaseAmount = storage.getOrDefault(fruitType, 0);
        if (purchaseAmount < amount) {
            throw new IllegalStateException("Not enough fruits");
        }
        int newAmount = storage.get(fruitType) - amount;
        storage.put(fruitType,newAmount);
        return newAmount;
    }*/
}
