package core.basesyntax.service.impl;

import core.basesyntax.constants.Activity;
import core.basesyntax.constants.Product;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.strategy.ActivityTypeStrategy;
import core.basesyntax.service.strategy.ActivityTypeStrategyImpl;
import core.basesyntax.strategy.ActivitiesStrategy;
import core.basesyntax.strategy.ActivitiesStrategyImpl;
import core.basesyntax.strategy.handlers.ActivityHandler;
import core.basesyntax.strategy.handlers.impl.BalanceActivityHandler;
import core.basesyntax.strategy.handlers.impl.PurchaseActivityHandler;
import core.basesyntax.strategy.handlers.impl.ReturnActivityHandler;
import core.basesyntax.strategy.handlers.impl.SupplyActivityHandler;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ProcessServiceCsvImpl implements ProcessService {
    private static final String APPLE_CSV_TYPE = "apple";
    private static final String BANANA_CSV_TYPE = "banana";
    private static final String CSV_PUNCTUATION_MARK = ",";
    private static final Integer ACTIVITY_CSV_TYPE = 0;
    private static final Integer PRODUCT_CSV_TYPE = 1;
    private static final Integer AMOUNT_CSV_TYPE = 2;
    private static final String BALANCE_CSV_TYPE = "b";
    private static final String SUPPLY_CSV_TYPE = "s";
    private static final String PURCHASE_CSV_TYPE = "p";
    private static final String RETURN_CSV_TYPE = "r";
    private static final Map<Activity, ActivityHandler> strategyMap = Map.of(
            Activity.BALANCE, new BalanceActivityHandler(),
            Activity.PURCHASE, new PurchaseActivityHandler(),
            Activity.RETURN, new ReturnActivityHandler(),
            Activity.SUPPLY, new SupplyActivityHandler());
    private static final Map<String, Activity> strategyActivityTypeMap = Map.of(
            BALANCE_CSV_TYPE, Activity.BALANCE,
            SUPPLY_CSV_TYPE, Activity.SUPPLY,
            PURCHASE_CSV_TYPE, Activity.PURCHASE,
            RETURN_CSV_TYPE, Activity.RETURN);
    private final ActivitiesStrategy activitiesStrategy
            = new ActivitiesStrategyImpl(strategyMap);
    private final ActivityTypeStrategy activityTypeStrategy
            = new ActivityTypeStrategyImpl(strategyActivityTypeMap);

    @Override
    public void processInfo(List<String> dataList) {
        dataList.stream()
                .map(dataLine -> dataLine.split(CSV_PUNCTUATION_MARK))
                .forEach(dataLine -> new DataLineProcessService().accept(dataLine));

    }

    private Activity getActivityType(String operation) {
        return activityTypeStrategy.get(operation);
    }

    private Product getProductType(String productName) {
        switch (productName) {
            case APPLE_CSV_TYPE -> {
                return Product.APPLE;
            }
            case BANANA_CSV_TYPE -> {
                return Product.BANANA;
            }
            default -> throw new RuntimeException("Invalid product");
        }
    }

    private class DataLineProcessService implements Consumer<String[]> {
        @Override
        public void accept(String[] dataLine) {
            Activity activityType = getActivityType(dataLine[ACTIVITY_CSV_TYPE]);
            Product productType = getProductType(dataLine[PRODUCT_CSV_TYPE]);
            Integer amount = Integer.valueOf(dataLine[AMOUNT_CSV_TYPE]);
            ActivityHandler activity = activitiesStrategy.get(activityType);
            activity.updateProductInfo(productType, amount);
        }
    }
}
