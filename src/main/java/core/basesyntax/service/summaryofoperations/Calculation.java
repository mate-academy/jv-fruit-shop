package core.basesyntax.service.summaryofoperations;

import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public interface Calculation {
    int getSumByOperationDependsOnFruit(Map<Operation, Map<String, List<Integer>>> fruitStorage,
                                        Operation operation, String fruit);
}
