package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StorageImpl implements Storage{
    private final static Map<String, Integer> supplies = new HashMap<>();

    @Override
    public Integer getAmount(String product) {
        return supplies.get(product);
    }

    @Override
    public Integer setAmount(String product, Integer amount) {
        return supplies.put(product, amount);
    }

    @Override
    public boolean contains(String product) {
        return supplies.containsKey(product);
    }

    @Override
    public Integer remove(String product) {
        return supplies.remove(product);
    }

    @Override
    public Integer put(String product, Integer amount) {
        return supplies.put(product, amount);
    }

    @Override
    public Set<String> getProductNames() {
        return supplies.keySet();
    }
}
