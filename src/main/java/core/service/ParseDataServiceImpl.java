package core.service;

import core.dao.FruitsDao;
import core.dao.FruitsDaoImpl;
import core.model.Operations;
import java.util.List;

public class ParseDataServiceImpl implements ParseDataService {
    private static final int ACTIVITY_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int AMOUNT_OF_FRUITS = 2;
    private final ActivitiesStrategy activitiesStrategy;
    private final FruitsDao fruitsDao;

    public ParseDataServiceImpl(ActivitiesStrategy activitiesStrategy, FruitsDao fruitsDao) {
        this.activitiesStrategy = activitiesStrategy;
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void applyOperationsToFruit(List<String> data) {
        for (String dataFromList : data) {
            String[] line = dataFromList.split(",");
            int fruitsInShop = fruitsDao.get(line[FRUIT_TYPE]);
            int operationAmount = Integer.parseInt(line[AMOUNT_OF_FRUITS]);
            if (operationAmount < 0) {
                throw new RuntimeException("Incorrect value of operation: "
                        + Integer.parseInt(line[AMOUNT_OF_FRUITS]));
            }
            fruitsDao.add(line[FRUIT_TYPE], activitiesStrategy.get(Operations
                    .operationFromString(line[ACTIVITY_TYPE]))
                    .calculateAmount(fruitsInShop, operationAmount));
        }
    }
}
