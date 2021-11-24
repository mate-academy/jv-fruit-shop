package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ResultGeneratorService;
import java.util.List;
import java.util.Map;

public class ResultGeneratorServiceImpl implements ResultGeneratorService {
    private final FruitStorageDao fruitStorageDao;

    public ResultGeneratorServiceImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public String generateResult(List<String> data) {
        StringBuilder result = new StringBuilder("fruit,quantity");
        for (Map.Entry<Fruit, Integer> fruit : fruitStorageDao.getAll().entrySet()) {
            result.append(System.lineSeparator())
                    .append(fruit.getKey().getName())
                    .append(",")
                    .append(fruit.getValue());
        }
        return result.append(System.lineSeparator()).toString();
    }
}
