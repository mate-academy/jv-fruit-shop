package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        fruitDao.add(fruitTransaction);
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
