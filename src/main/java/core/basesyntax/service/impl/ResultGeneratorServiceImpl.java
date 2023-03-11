package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ResultGeneratorService;
import java.util.Map;

public class ResultGeneratorServiceImpl implements ResultGeneratorService {
    private final FruitStorageDao fruitStorageDao;

    public ResultGeneratorServiceImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public String generateResult() {
        StringBuilder result = new StringBuilder("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : fruitStorageDao.getAll().entrySet()) {
            result.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue());
        }
        return result.append(System.lineSeparator()).toString();
    }
}
