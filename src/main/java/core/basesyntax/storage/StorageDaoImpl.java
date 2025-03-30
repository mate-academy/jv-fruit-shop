package core.basesyntax.storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, int quantity) {
        if (Storage.fruitStorage.containsKey(fruit)) {
            int result = Storage.fruitStorage.get(fruit) + quantity;
            Storage.fruitStorage.put(fruit, result);
        } else {
            Storage.fruitStorage.put(fruit, quantity);
        }
    }

    @Override
    public void remove(String fruit, int quantity) {
        int result = Storage.fruitStorage.get(fruit) - quantity;
        Storage.fruitStorage.put(fruit, result);
    }
}
