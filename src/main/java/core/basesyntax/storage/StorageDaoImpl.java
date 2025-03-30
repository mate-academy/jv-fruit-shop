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
        if (!Storage.getFruitStorage().containsKey(fruit)) {
            throw new RuntimeException("There's no " + fruit + "in storage.");
        }
        int result = Storage.getFruitStorage().get(fruit) - quantity;
        if (result < 0) {
            throw new RuntimeException(fruit + " quantity can't be " + result);
        }
        Storage.getFruitStorage().put(fruit, result);
    }
}
