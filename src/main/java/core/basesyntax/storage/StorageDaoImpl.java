package core.basesyntax.storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, int quantity) {
        if (Storage.getFruitStorage().containsKey(fruit)) {
            int result = Storage.getFruitStorage().get(fruit) + quantity;
            Storage.getFruitStorage().put(fruit, result);
        } else {
            Storage.getFruitStorage().put(fruit, quantity);
        }
    }

    @Override
    public void remove(String fruit, int quantity) {
        int result = Storage.getFruitStorage().get(fruit) - quantity;
        Storage.getFruitStorage().put(fruit, result);
    }
}
