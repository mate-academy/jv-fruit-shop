package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public boolean containsFruit(Fruit fruit) {
        return Storage.getStorage().containsKey(fruit);
    }

    @Override
    public int checkAvailableQuantity(Fruit fruit) {
        return Storage.getStorage().get(fruit);
    }

    @Override
    public void add(Fruit fruit, int qty) {
        Storage.getStorage().put(fruit, qty);
    }

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry: Storage.getStorage().entrySet()) {
            stringBuilder.append(entry.getKey().getName()).append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
