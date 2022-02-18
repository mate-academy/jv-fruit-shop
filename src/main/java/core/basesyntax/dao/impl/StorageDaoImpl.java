package core.basesyntax.dao.impl;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import java.util.NoSuchElementException;

public class StorageDaoImpl implements StorageDao {

    public void add(String fruitName, int amount) {
        try {
            get(fruitName).setAmount(get(fruitName).getAmount() + amount);
        } catch (NoSuchElementException e) {
            Fruit newFruit = new Fruit(fruitName);
            newFruit.setAmount(amount);
            storage.add(newFruit);
        }
    }

    public void substract(String fruitName, int amount) {
        try {
            if (amount <= get(fruitName).getAmount()) {
                get(fruitName).setAmount(get(fruitName).getAmount() - amount);
            } else {
                throw new RuntimeException(
                        "FAILED TO SUBSTRACT: amount: "
                                + amount + " has exceeded an amount of this fruit in storage"
                );
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException(
                    "FAILED TO SUBSTRACT: no such fruit in storage: " + fruitName
            );
        }
    }

    public Fruit get(String fruitName) {
        return storage.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException(
                                "FAILED TO GET: no such fruit in data base: "
                                + fruitName)
                );
    }
}
