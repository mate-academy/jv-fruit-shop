package core.basesyntax.db;

public class StorageDaoImpl implements StorageDao {
    @Override
    public boolean increaseFruitsAmount(String fruit, int quantityToAdd) {
        int currentQuantity = Storage.fruitsMap.get(fruit);
        Storage.fruitsMap.put(fruit, currentQuantity + quantityToAdd);
        return true;
    }

    @Override
    public boolean decreaseFruitsAmount(String fruit, int quantityToSubtract) {
        int currentQuantity = Storage.fruitsMap.get(fruit);
        if (currentQuantity - quantityToSubtract < 0) {
            throw new RuntimeException("Fruit balance can`t be less than null after decreasing");
        }
        Storage.fruitsMap.put(fruit, currentQuantity - quantityToSubtract);
        return true;
    }

    @Override
    public boolean addNewFruit(String fruit, int quantity) {
        Storage.fruitsMap.put(fruit, quantity);
        return true;
    }

    @Override
    public boolean isInStorage(String fruit) {
        return Storage.fruitsMap.containsKey(fruit);
    }

    @Override
    public int getAmountOf(String fruit) {
        return Storage.fruitsMap.get(fruit);
    }
}
