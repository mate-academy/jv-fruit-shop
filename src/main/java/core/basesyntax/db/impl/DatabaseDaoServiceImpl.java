package core.basesyntax.db.impl;

import core.basesyntax.db.Database;
import core.basesyntax.db.DatabaseDaoService;
import java.util.Map;

public class DatabaseDaoServiceImpl implements DatabaseDaoService {
    @Override
    public void put(String product, Integer amount) {
        Database.database.put(product, amount);
    }

    @Override
    public void reduceAmount(String product, Integer amount) {
        Integer oldAmount = Database.database.get(product);
        Database.database.put(product, oldAmount - amount);
    }

    @Override
    public void increaseAmount(String product, Integer amount) {
        Integer oldAmount = Database.database.get(product);
        Database.database.put(product, oldAmount + amount);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Map.copyOf(Database.database);
    }

    @Override
    public Integer getProductAmount(String product) {
        return Database.database.get(product);
    }
}
