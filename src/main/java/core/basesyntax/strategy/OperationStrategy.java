package core.basesyntax.strategy;

import core.basesyntax.strategy.operation.OperationHandler;
import java.util.List;

public interface OperationStrategy {
    List<String> getListOfOperations();

    OperationHandler get(String operation);
}
