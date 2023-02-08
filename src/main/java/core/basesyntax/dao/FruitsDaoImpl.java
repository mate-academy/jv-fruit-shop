package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.entity.FruitTransaction;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitsDaoImpl implements FruitsDao {

    @Override
    public void addListFruitsStorage(FruitTransaction stringListFruits) {
        Storage.fruitStorage.add(stringListFruits);
    }

    @Override
    public List<FruitTransaction> getAllListFruits(String fruit) {
        return Storage.fruitStorage.stream()
                .filter(t -> t.getFruit().equals(fruit))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<FruitTransaction>> getMapFruitByActivity(String fruits) {
        return getAllListFruits(fruits).stream()
                .collect(Collectors
                        .groupingBy(FruitTransaction::getActivity));
    }

}
