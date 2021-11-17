package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitBox;

public class FruitBoxDaoImpl implements FruitBoxDao {
    @Override
    public void add(FruitBox fruitBox) {
        Storage.storage.add(fruitBox);

    }

    @Override
    public FruitBox get(String fruitType) {
        return Storage.storage.stream()
                .filter(f -> f.getFruitType().equals(fruitType))
                .findFirst()
                .orElse(null);
    }
}
