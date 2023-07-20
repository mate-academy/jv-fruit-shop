package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.service.ActivityTypeStrategy;
import core.basesyntax.service.impl.service.ConvertService;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertServiceImpl implements ConvertService {
    private static final String COMA_DELIMITER = ",";
    private static final String EXCEPTION_INFO
            = "Incorrect operation type or file contains empty line!"
            + " Insert correct type to input file or delete empty line";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COLUMN_NAME = "type";
    private static final String INVALID_INPUT_PARAMETER
            = "Invalid input parameter in convertData()";
    private ActivityTypeStrategy activityTypeStrategy;

    public ConvertServiceImpl(ActivityTypeStrategy activityTypeStrategy) {
        this.activityTypeStrategy = activityTypeStrategy;
    }

    @Override
    public List<FruitTransaction> convertData(List<String> strings) {
        if (strings == null) {
            throw new RuntimeException(INVALID_INPUT_PARAMETER);
        }
        return strings.stream()
                .filter(line -> !line.startsWith(COLUMN_NAME))
                .map(this::getFruitTransactionObject)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransactionObject(String line) {
        String[] row = line.split(COMA_DELIMITER);
        FruitTransaction.Operation activityType;
        try {
            activityType = activityTypeStrategy.get(row[TYPE_INDEX]).getActivityType();
        } catch (NullPointerException e) {
            throw new RuntimeException(EXCEPTION_INFO);
        }
        String fruit = row[FRUIT_INDEX];
        int quantity = Integer.parseInt(row[QUANTITY_INDEX]);
        return new FruitTransaction(activityType, fruit, quantity);
    }
}
