package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;
import java.util.List;

public interface OperationStrategy {
    List<String> getListOfOperations();

    OperationHandler get(String operation);
}
