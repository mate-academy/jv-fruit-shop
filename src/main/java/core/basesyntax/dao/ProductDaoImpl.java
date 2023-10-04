package core.basesyntax.dao;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void update(FruitTransaction fruitTransaction, int count) {
        FruitsStorage.FRUIT_MAP.put(fruitTransaction.getFruit(), count);
    }

    @Override
    public int getQuantityOf(FruitTransaction fruitTransaction) {
        return FruitsStorage.FRUIT_MAP.getOrDefault(fruitTransaction.getFruit(), 0);
    }

    @Override
    public List<String> getAll() {
        String joiningSymbol = ",";
        return FruitsStorage.FRUIT_MAP.entrySet().stream()
                .map(entry -> entry.getKey() + joiningSymbol + entry.getValue())
                .collect(Collectors.toList());
    }
}
