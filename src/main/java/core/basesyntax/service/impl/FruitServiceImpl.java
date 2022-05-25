package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void update(String fruitName, Integer amount) {
        fruitDao.update(fruitName, amount);
    }

    @Override
    public Integer getQuantity(String fruitName) {
        return fruitDao.getQuantity(fruitName);
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits.entrySet().stream()
                .map(i -> new Fruit(i.getKey(), i.getValue()))
                .collect(Collectors.toList());
    }
}
