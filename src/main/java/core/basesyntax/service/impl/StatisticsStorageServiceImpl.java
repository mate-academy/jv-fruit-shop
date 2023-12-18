package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.StatisticsStorageService;
import java.util.Map;

public class StatisticsStorageServiceImpl implements StatisticsStorageService {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void store(Map<String, Integer> statistics) {
        fruitDao.addData(statistics);
    }
}
