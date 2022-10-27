package core.basesyntax.service.impl;

import core.basesyntax.service.DataProcessingService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DataProcessingServiceImpl implements DataProcessingService {
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int QUANTITY = 2;

    public void processData(List<String> data, OperationStrategy strategy) {
        data.remove(0);
        for (String line : data) {
            String[] dataToProcess = line.split(DATA_SEPARATOR);
            OperationHandler operationHandler = strategy.get(dataToProcess[OPERATION_TYPE]);
            operationHandler.valueOperation(dataToProcess[FRUIT_TYPE],
                            Integer.parseInt(dataToProcess[QUANTITY]));
        }
    }
}
