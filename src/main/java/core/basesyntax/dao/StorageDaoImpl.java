package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void addProductCount(String productName, Integer count) {
        if (count < 0) {
            throw new RuntimeException("Invalid operation: amount of products nut enough");
        }
        Storage.fruitsCount.put(productName, count);
    }

    @Override
    public Integer getProductCount(String productName) {
        return Storage.fruitsCount.get(productName);
    }

    @Override
    public List<String> getProductInfo() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: Storage.fruitsCount.entrySet()) {
            result.add(String.format("%s,%d", entry.getKey(), entry.getValue()));
        }
        return result;
    }

}
