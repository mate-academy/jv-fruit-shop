package core.basesyntax.db;

import core.basesyntax.model.Fruit;

public class StorageDaoImpl implements StorageDao {

    @Override
    public boolean increaseFruitsAmount(Fruit fruit, int quantityToAdd) {
        if (!Storage.fruitsMap.containsKey(fruit)) {
            throw new RuntimeException("There is no such fruit in Storage");
        }
        int currentQuantity = Storage.fruitsMap.get(fruit);
        Storage.fruitsMap.put(fruit, currentQuantity + quantityToAdd);
        return true;
    }

    @Override
    public boolean decreaseFruitsAmount(Fruit fruit, int quantityToSubtract) {
        if (!Storage.fruitsMap.containsKey(fruit)) {
            throw new RuntimeException("There is no such fruit in Storage");
        }
        int currentQuantity = Storage.fruitsMap.get(fruit);
        if (currentQuantity - quantityToSubtract < 0) {
            throw new RuntimeException("Fruit balance can`t be less than null after decreasing");
        }
        Storage.fruitsMap.put(fruit, currentQuantity - quantityToSubtract);
        return true;
    }

    @Override
    public boolean addNewFruit(Fruit fruit, int quantity) {
        if (Storage.fruitsMap.containsKey(fruit)) {
            throw new RuntimeException("Such fruit already exists, you can only add a new fruit");
        }
        Storage.fruitsMap.put(fruit, quantity);
        return true;
    }
}
