package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductDao;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void update(FruitTransaction fruitTransaction, int count) {
        Storage.FRUIT_MAP.put(fruitTransaction.getFruit(), count);
    }

    @Override
    public int getQuantityOf(FruitTransaction fruitTransaction) {
        return Storage.FRUIT_MAP.getOrDefault(fruitTransaction.getFruit(), 0);
    }

    @Override
    public List<String> getAll() {
        String joiningSymbol = ",";
        return Storage.FRUIT_MAP.entrySet().stream()
                .map(entry -> entry.getKey() + joiningSymbol + entry.getValue())
                .collect(Collectors.toList());
    }
}
