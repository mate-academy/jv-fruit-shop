package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectDaoImpl implements ProductDao {
    @Override
    public void update(FruitTransaction fruitTransaction, int count) {
        FruitStorage.Storage_Map.put(fruitTransaction.getFruit(), count);
    }

    @Override
    public int getQuantity(FruitTransaction fruitTransaction) {
        return FruitStorage.Storage_Map.get(fruitTransaction.getFruit());
    }

    @Override
    public List<String> getAll() {
        String connectSymbol = ",";
        return FruitStorage.Storage_Map.entrySet().stream()
                .map(entry -> entry.getKey() + connectSymbol + entry.getValue())
                .collect(Collectors.toList());
    }
}
