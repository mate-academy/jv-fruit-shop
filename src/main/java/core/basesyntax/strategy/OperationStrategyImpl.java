package core.basesyntax.strategy;

import java.util.List;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public void accept(List<String[]> data, Map<String, OperationHandler> operationHandlerMap) {
        for (String[] value : data) {
            operationHandlerMap.get(value[OPERATION_INDEX])
                    .accept(value[FRUIT_INDEX], value[QUANTITY_INDEX]);
        }
    }

}
