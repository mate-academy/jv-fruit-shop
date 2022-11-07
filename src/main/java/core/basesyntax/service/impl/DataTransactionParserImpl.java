package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.DataTransactionParser;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class DataTransactionParserImpl implements DataTransactionParser {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final OperationStrategy operationStrategy;

    public DataTransactionParserImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> parseDataTransaction(String data) {
        String[] dataToArray = data.split(System.lineSeparator());
        for (String lineInArr : dataToArray) {
            String[] arrWithOperatorAndFruitQuantity = lineInArr.split(COMMA);
            String operation = arrWithOperatorAndFruitQuantity[OPERATION_INDEX];
            String fruitName = arrWithOperatorAndFruitQuantity[FRUIT_NAME_INDEX];
            String quantity = arrWithOperatorAndFruitQuantity[QUANTITY_INDEX];
            OperationHandler operationHandler = operationStrategy.getOperation(operation);
            operationHandler.applyOperation(fruitName, Integer.parseInt(quantity));
        }
        return Storage.FRUIT_STORAGE;
    }
}
