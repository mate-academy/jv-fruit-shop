package core.basesyntax.processdata;

import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.operationstrategy.operation.OperationHandler;
import core.basesyntax.operationstrategy.operation.OperationType;
import java.util.List;
import java.util.Map;

public class DataProcessorImpl implements DataProcessor {
    private static final int OPERATION_TYPE_POSITION = 0;
    private static final int ITEM_NAME_POSITION = 1;
    private static final int ITEM_VALUE_POSITION = 2;
    private final OperationStrategy operationStrategy;

    public DataProcessorImpl(Map<OperationType, OperationHandler> operationHandlerMap) {
        operationStrategy = new OperationStrategyImpl(operationHandlerMap);
    }

    @Override
    public void process(List<List<String>> processedData) {
        for (List<String> dataLine : processedData) {
            OperationType operationType = OperationType
                    .valueOf(dataLine.get(OPERATION_TYPE_POSITION).toUpperCase());
            String itemName = dataLine.get(ITEM_NAME_POSITION);
            Integer value = Integer.parseInt(dataLine.get(ITEM_VALUE_POSITION));
            operationStrategy.get(operationType).processOperation(itemName, value);
        }
    }
}
