package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileCsvService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.strategy.ActivityStrategy;
import core.basesyntax.service.strategy.ActivityStrategyImpl;
import core.basesyntax.service.strategy.handler.ActivityHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private final FileCsvService fileService;
    private final Map<Operation, ActivityHandler> strategy;

    public FruitServiceImpl(FileCsvService fileService, Map<Operation, ActivityHandler> strategy) {
        this.fileService = fileService;
        this.strategy = strategy;
    }

    @Override
    public void toProcessActivities(String fileName) {
        List<String> allActivities = fileService.readAllLines(fileName);
        for (int i = 1; i < allActivities.size(); i++) {
            String activity = allActivities.get(i);
            activity = activity.replaceAll("\"", "");
            FruitTransaction fruitTransaction = createFruitTransaction(activity);
            ActivityStrategy activityStrategy = new ActivityStrategyImpl(strategy);
            ActivityHandler activityHandler = activityStrategy
                    .get(fruitTransaction.getOperation());
            activityHandler.accept(fruitTransaction);
        }
        fileService.createReport("report.csv");
    }

    private FruitTransaction createFruitTransaction(String activity) {
        String[] row = activity.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Operation
                .getOperationFromCode(row[INDEX_OF_OPERATION]));
        fruitTransaction.setFruit(new Fruit(row[INDEX_OF_FRUIT]));
        fruitTransaction.setQuantity(Integer.parseInt(row[INDEX_OF_QUANTITY]));
        return fruitTransaction;
    }
}
