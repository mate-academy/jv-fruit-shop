package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.FruitWorkStrategy;

public class StrategyServiceImpl implements StrategyService {
    private static final int KEY_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_NUMBER_INDEX = 2;

    @Override
    public void workWithStrategy(String[] fileData, FruitWorkStrategy fruitWork, FruitDao fruitDao) {
        for (String dataLine : fileData) {
            String[] dataLineArr = dataLine.split(",");
            String key = dataLineArr[KEY_INDEX];
            String fruitName = dataLineArr[FRUIT_NAME_INDEX];
            int fruitNumber = Integer.parseInt(dataLineArr[FRUIT_NUMBER_INDEX]);
            fruitWork.get(key).workWithFruitInStorage(fruitNumber, fruitName, fruitDao);
        }
    }
}
