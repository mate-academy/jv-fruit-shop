package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Set;

public class DaoImpl implements Dao {
    @Override
    public Integer get(String product) {
        return Storage.supplies.get(product);
    }

    @Override
    public Integer put(String product, Integer amount) {
        return Storage.supplies.put(product, amount);
    }

    @Override
    public boolean contains(String product) {
        return Storage.supplies.containsKey(product);
    }

    @Override
    public Integer remove(String product) {
        return Storage.supplies.remove(product);
    }

    @Override
    public Set<String> getProductNames() {
        return Storage.supplies.keySet();
    }
}
