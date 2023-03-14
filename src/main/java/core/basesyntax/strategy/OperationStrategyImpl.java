package core.basesyntax.strategy;

import java.util.List;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public void accept(List<String> data, Map<String, OperationHandler> operationHandlerMap) {
        data.remove(0);
        for (String value : data) {
            int indexOfSeparator = value.indexOf(OperationHandler.COMMA_SEPARATOR);
            operationHandlerMap.get(value.substring(0, indexOfSeparator))
                    .accept(value.substring(indexOfSeparator + 1));
        }
    }

}
