package core.basesyntax.service;

import core.basesyntax.operation.StoreOperation;
import java.util.List;
import java.util.Map;

public interface OperationListProcessor {
    Map<String, Integer> process(List<StoreOperation> operationsList);
}
