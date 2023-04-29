package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.ServiceStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShopServiceImpl implements ShopService {
    private static final String SPLITTING_SYMBOL = ",";
    private static final int INDEX_OF_FIRST_LINE = 0;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_NUMBER_OF_FRUITS = 2;
    private FruitDao fruitDao;
    private ServiceStrategy strategy;

    public ShopServiceImpl(FruitDao fruitDao, ServiceStrategy strategy) {
        this.fruitDao = fruitDao;
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> processData() {
        List<String> listOfFruits = new ArrayList<>();
        List<String> dataFromFile = fruitDao.get();
        dataFromFile.remove(INDEX_OF_FIRST_LINE);
        for (String line : dataFromFile) {
            listOfFruits.add(line.split(SPLITTING_SYMBOL)[INDEX_OF_FRUIT]);
        }
        listOfFruits = listOfFruits.stream()
                .distinct()
                .collect(Collectors.toList());
        for (String fruit : listOfFruits) {
            Storage.storage.put(fruit, 0);
        }
        for (String line : dataFromFile) {
            String[] arrayOfValuesOnTheLine = line.split(SPLITTING_SYMBOL);
            String operation = arrayOfValuesOnTheLine[INDEX_OF_OPERATION];
            String fruit = arrayOfValuesOnTheLine[INDEX_OF_FRUIT];
            String number = arrayOfValuesOnTheLine[INDEX_OF_NUMBER_OF_FRUITS];
            int resultOfOperation = strategy.getOperation(operation)
                    .operate(fruit, Integer.parseInt(number));
            Storage.storage.put(fruit, resultOfOperation);
        }
        return Storage.storage;
    }
}
