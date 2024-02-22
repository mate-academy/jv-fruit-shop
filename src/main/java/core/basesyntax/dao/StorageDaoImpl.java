package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {
    public static void removeProduct(String fruit, int minuend) {
        Integer currentValue = Storage.foodStorage.get(fruit);

        if (currentValue != null && currentValue >= minuend) {
            Storage.foodStorage.put(fruit, currentValue - minuend);
        } else {
            throw new RuntimeException("Not enough " + fruit + " in the storage to remove from");
        }
    }

    public static void addProduct(String fruit, int addend) {
        Storage.foodStorage.merge(fruit, addend, Integer::sum);
    }

    public static void clear() {
        Storage.foodStorage.clear();
    }

    public String getStorageContents() {
        StringBuilder sb = new StringBuilder();
        Storage.foodStorage.entrySet().stream().forEach(e -> {
            sb.append(e.getKey() + "," + e.getValue() + System.lineSeparator());
        });

        return sb.toString();
    }
}
