package core.basesyntax.strategy;

import java.util.List;

public interface OperationStrategy {
    List<String> getListOfOperations();

    OperationHandler get(String operation);
}
