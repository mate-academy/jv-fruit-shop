package core.basesyntax.service.impl;

import core.basesyntax.constants.Activities;
import core.basesyntax.constants.Products;
import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.ActivitiesStrategy;
import core.basesyntax.strategy.ActivitiesStrategyImpl;
import core.basesyntax.strategy.handlers.ActivitiesHandler;
import java.util.List;
import java.util.function.Consumer;

public class ProcessServiceCsvImpl implements ProcessService {

    public static final String BALANCE_CSV_TYPE = "b";
    public static final String SUPPLY_CSV_TYPE = "s";
    public static final String PURCHASE_CSV_TYPE = "p";
    public static final String RETURN_CSV_TYPE = "r";
    public static final String APPLE_CSV_TYPE = "apple";
    public static final String BANANA_CSV_TYPE = "banana";
    public static final String CSV_PUNCTUATION_MARK = ",";
    private final ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl();

    @Override
    public void processInfo(List<String> dataList) {
        dataList.stream()
                .map(dataLine -> dataLine.split(CSV_PUNCTUATION_MARK))
                .forEach(dataLine -> new ForEachConsumer().accept(dataLine));

    }

    private Activities getActivityType(String operation) {
        switch (operation) {
            case BALANCE_CSV_TYPE -> {
                return Activities.BALANCE;
            }
            case SUPPLY_CSV_TYPE -> {
                return Activities.SUPPLY;
            }
            case PURCHASE_CSV_TYPE -> {
                return Activities.PURCHASE;
            }
            case RETURN_CSV_TYPE -> {
                return Activities.RETURN;
            }
            default -> throw new RuntimeException("Invalid operation");
        }
    }

    private Products getProductType(String productName) {
        switch (productName) {
            case APPLE_CSV_TYPE -> {
                return Products.APPLE;
            }
            case BANANA_CSV_TYPE -> {
                return Products.BANANA;
            }
            default -> throw new RuntimeException("Invalid product");
        }
    }

    private class ForEachConsumer implements Consumer<String[]> {
        @Override
        public void accept(String[] dataLine) {
            Activities activityType = getActivityType(dataLine[0]);
            Products productType = getProductType(dataLine[1]);
            Integer amount = Integer.valueOf(dataLine[2]);
            ActivitiesHandler activity = activitiesStrategy.get(activityType);
            activity.updateProductInfo(productType, amount);
        }
    }
}
