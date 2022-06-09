package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.stream.Collectors;

public class FruitDaoImp implements FruitDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.warehouse.add(fruitTransaction);
    }

    @Override
    public FruitTransaction get(String fruit) {
        return Storage.warehouse.stream()
                .filter(f -> f.getFruit().equals(fruit))
                .findFirst()
                .get();
    }

    @Override
    public String getAll() {
        return Storage.warehouse.stream()
                .distinct()
                .map(f -> System.lineSeparator() + f.getFruit()
                        + "," + f.getQuantity())
                .collect(Collectors.joining());
    }
}
