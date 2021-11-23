package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ResultGeneratorService;

import java.util.List;

public class ResultGeneratorServiceImpl implements ResultGeneratorService {
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public String generateResult(List<String> data) {
        StringBuilder result = new StringBuilder("fruit,quantity");
        for (Fruit fruit : fruitStorageDao.getAll()) {
            result.append(System.lineSeparator())
                    .append(fruit.getName())
                    .append(",")
                    .append(fruit.getQuantity());
        }
        return result.append(System.lineSeparator()).toString();
    }
}
