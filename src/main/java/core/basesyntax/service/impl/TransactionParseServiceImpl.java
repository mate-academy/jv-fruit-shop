package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionParseService;
import java.util.ArrayList;
import java.util.List;

public class TransactionParseServiceImpl implements TransactionParseService {
    private static final String DATA_SPLITTER = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseInputData(List<String> inputData) {
        List<FruitTransaction> activities = new ArrayList<>();
        for (String items : inputData) {
            String[] data = items.split(DATA_SPLITTER);
            String activityType = data[OPERATION_TYPE_INDEX];
            String fruitName = data[FRUIT_TYPE_INDEX];
            int quantity = Integer.parseInt(data[FRUIT_QUANTITY_INDEX]);
            FruitTransaction activity = new FruitTransaction(Operation
                    .getOperation(activityType), fruitName, quantity);
            activities.add(activity);
        }
        return activities;
    }
}
