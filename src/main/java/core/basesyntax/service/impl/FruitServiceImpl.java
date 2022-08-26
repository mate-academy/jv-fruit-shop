package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private final StorageDao storageDao;

    public FruitServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void update(String fruitName, Integer amount) {
        storageDao.update(fruitName, amount);
    }

    @Override
    public Integer getAmount(String fruitName) {
        return storageDao.getAmount(fruitName);
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruitsStorage.entrySet().stream()
                .map(i -> new Fruit(i.getKey(), i.getValue()))
                .collect(Collectors.toList());
    }
}
