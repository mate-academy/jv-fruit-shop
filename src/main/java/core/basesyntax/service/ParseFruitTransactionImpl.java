package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;

public class ParseFruitTransactionImpl implements ParseFruitTransaction {
    private static final int HEAD_INDEX = 0;
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public void parseFruitTransaction(List<String> inputData, OperationStrategy operation) {
        inputData.remove(HEAD_INDEX);
        for (String data: inputData) {
            String[] splitData = data.split(DATA_SEPARATOR);
            OperationHandler operationHandler = operation.get(splitData[OPERATION_INDEX]);
            operationHandler.doOperation(splitData[FRUIT_INDEX],
                    Integer.valueOf(splitData[QUANTITY_INDEX]));
        }
    }
}
