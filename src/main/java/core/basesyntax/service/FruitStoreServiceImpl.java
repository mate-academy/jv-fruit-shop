package core.basesyntax.service;

import core.basesyntax.dao.FruitStoreDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.action.ActionHandler;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitStoreServiceImpl implements FruitStoreService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMMA_DELIMITER = ",";
    private static final int ACTION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int ZERO_NUM = 0;
    private FruitStoreDao fruitStoreDao;
    private ActionStrategy activityStrategy;

    public FruitStoreServiceImpl(FruitStoreDao fruitStoreDao, ActionStrategy activityStrategy) {
        this.fruitStoreDao = fruitStoreDao;
        this.activityStrategy = activityStrategy;
    }

    @Override
    public String createNewReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_TITLE).append(System.lineSeparator());
        Map<Fruit, Integer> fruitQuantityMap = fruitStoreDao.getAllFruits();
        stringBuilder.append(fruitQuantityMap.entrySet().stream()
                .map(entry -> entry.getKey().getName() + COMMA_DELIMITER + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator())));
        return stringBuilder.toString();
    }

    @Override
    public void addDataToStorage(List<String> data) {
        for (String record : data) {
            String[] currentActionData = record.split(COMMA_DELIMITER);
            String actionType = currentActionData[ACTION_INDEX];
            String fruitName = currentActionData[FRUIT_NAME_INDEX];
            Fruit fruit = new Fruit(fruitName);
            int inputQuantity = Integer.parseInt(currentActionData[QUANTITY_INDEX]);
            if (inputQuantity < 0) {
                throw new RuntimeException("Input data can't be negative!");
            }
            int currentQuantity = fruitStoreDao.getFruitQuantity(fruit).orElse(ZERO_NUM);
            ActionHandler actionHandler = activityStrategy
                    .get(actionType)
                    .orElseThrow(() -> new RuntimeException("Wrong action: " + actionType));
            int newQuantity = actionHandler.calculateQuantity(currentQuantity, inputQuantity);
            fruitStoreDao.addFruit(fruit, newQuantity);
        }
    }
}
