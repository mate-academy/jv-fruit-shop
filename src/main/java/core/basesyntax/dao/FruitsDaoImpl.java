package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.entity.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public void addFruitsStorage(FruitTransaction stringListFruits) {
        Storage.fruitStorage.add(stringListFruits);
    }

    @Override
    public List<FruitTransaction> getAllListFruits(String fruit) {
        return Storage.fruitStorage.stream()
                .filter(t -> t.getFruit().equals(fruit))
                .collect(Collectors.toList());
    }
}
