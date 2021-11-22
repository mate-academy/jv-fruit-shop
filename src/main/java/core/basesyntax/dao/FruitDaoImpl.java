package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.math.BigDecimal;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public BigDecimal getBalance(Fruit.Type type) {
        return Storage.storage.entrySet().stream()
                .filter(e -> e.getKey() == type)
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(new BigDecimal(0));
    }

    @Override
    public BigDecimal add(Fruit.Type type, BigDecimal amount) {
        Storage.storage.put(type, getBalance(type).add(amount));
        return Storage.storage.get(type);
    }

    @Override
    public Map<Fruit.Type, BigDecimal> getStorage() {
        return Storage.storage;
    }
}

