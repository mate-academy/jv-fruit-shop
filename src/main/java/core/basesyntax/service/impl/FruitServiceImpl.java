package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.strategy.ActivityStrategy;
import core.basesyntax.service.strategy.ActivityStrategyImpl;
import core.basesyntax.service.strategy.handler.ActivityHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String FRUIT_COLUMN_NAME = "Fruit";
    private static final String QUANTITY_COLUMN_NAME = "Quantity";
    private static final String COMA = ",";
//    private static final String NEW_LINE = "\n";
    private final Map<Operation, ActivityHandler> strategy;

    public FruitServiceImpl(Map<Operation, ActivityHandler> strategy) {
        this.strategy = strategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            ActivityStrategy activityStrategy = new ActivityStrategyImpl(strategy);
            ActivityHandler activityHandler = activityStrategy
                    .get(transaction.getOperation());
            activityHandler.accept(transaction);
        }
    }

    @Override
    public List<String> createReport() {
//        StringBuilder builder = new StringBuilder();
//        builder.append(FRUIT_COLUMN_NAME).append(COMA).append(QUANTITY_COLUMN_NAME);
//        for (Map.Entry<Fruit, Integer> entry : Storage.getFruits().entrySet()) {
//            builder.append(NEW_LINE).append(entry.getKey().getName())
//                    .append(COMA).append(entry.getValue());
//        }
//        return builder.toString();
        List<String> records = new ArrayList<>();
        records.add(FRUIT_COLUMN_NAME + COMA + QUANTITY_COLUMN_NAME);
        for (Map.Entry<Fruit, Integer> entry : Storage.getFruits().entrySet()) {
            records.add(entry.getKey().getName() + COMA + entry.getValue());
        }
        return records;
    }
}
