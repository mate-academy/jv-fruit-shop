package core.basesyntax.service.impl;

import core.basesyntax.db.Store;
import core.basesyntax.service.DataParserService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class DataParserServiceImpl implements DataParserService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final OperationStrategy operationStrategy;

    public DataParserServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> parseData(String data) {
        String[] dataToArray = data.split(System.lineSeparator());
        for (String lineInArr : dataToArray) {
            String[] arrWithOperatorAndFruitQuantity = lineInArr.split(COMMA);
            String operation = arrWithOperatorAndFruitQuantity[OPERATION_INDEX];
            String fruitName = arrWithOperatorAndFruitQuantity[FRUIT_NAME_INDEX];
            String quantity = arrWithOperatorAndFruitQuantity[QUANTITY_INDEX];
            OperationHandler operationHandler = operationStrategy.getOperation(operation);
            operationHandler.getResultBalance(fruitName, Integer.parseInt(quantity));
        }
        return Store.FRUIT_STORAGE;
    }
}
