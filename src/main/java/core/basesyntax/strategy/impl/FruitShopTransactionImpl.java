package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitShopTransaction;
import java.util.HashMap;
import java.util.Map;

public class FruitShopTransactionImpl implements FruitShopTransaction {
    private static final String WORDS_SPLITERATOR = ",";
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    @Override
    public Map<String, Integer> fruitTransaction(String[] activity) {
        Map<String, Integer> dataForReport = new HashMap<>();
        String[] activityData;
        String activityType;
        String fruit;
        int quantity;
        for (String data : activity) {
            activityData = data.split(WORDS_SPLITERATOR);
            activityType = activityData[ACTIVITY_TYPE_INDEX];
            fruit = activityData[FRUIT_INDEX];
            quantity = Integer.parseInt(activityData[QUANTITY_INDEX]);
            doActivity(dataForReport, activityType, fruit, quantity);
        }
        return dataForReport;
    }

    private void doActivity(Map<String, Integer> dataForReport, String activityType,
                            String fruit, Integer quantity) {
        switch (activityType) {
            case BALANCE:
            case SUPPLY:
            case RETURN:
                if (existFruit(dataForReport, fruit)) {
                    dataForReport.put(fruit, quantity);
                } else {
                    dataForReport.replace(fruit, dataForReport.get(fruit) + quantity);
                }
                break;
            case PURCHASE:
                if (existFruit(dataForReport, fruit)) {
                    dataForReport.put(fruit, -quantity);
                } else {
                    dataForReport.replace(fruit, dataForReport.get(fruit) - quantity);
                }
                break;
            default: throw new RuntimeException("Invalid data!");
        }
    }

    private boolean existFruit(Map<String, Integer> dataForReport, String fruit) {
        return !dataForReport.containsKey(fruit);
    }
}
