package core.basesyntax.strategy;

import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.Operations;
import java.util.List;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public void accept(List<String> data) {
        data.remove(0);
        for (String value : data) {
            int indexOfSeparator = value.indexOf(OperationHandler.COMMA_SEPARATOR);
            Operations.OPERATIONS.get(value.substring(0, indexOfSeparator))
                    .accept(value.substring(indexOfSeparator + 1));
        }
    }

}
