package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;

public class FruitStorageDao {
    public void create(String fruitName, int quantity) {
        FruitStorage.storage.put(fruitName, quantity);
    }

    public void add(String fruitName, int quantity) {
        paramsValidator(fruitName, quantity);

        FruitStorage.storage.put(fruitName, FruitStorage.storage.get(fruitName) + quantity);
    }

    public void subtract(String fruitName, int quantity) {
        paramsValidator(fruitName, quantity);

        FruitStorage.storage.put(fruitName, FruitStorage.storage.get(fruitName) - quantity);
    }

    private void paramsValidator(String fruitName, int quantity) {
        if (!FruitStorage.storage.containsKey(fruitName)) {
            throw new RuntimeException(
                    "PURCHASE, RETURN and SUPPLY operations can't be done before"
                            + " BALANCE was done at least once. But you: "
                            + fruitName
                            + "," + quantity
            );
        }
    }
}
