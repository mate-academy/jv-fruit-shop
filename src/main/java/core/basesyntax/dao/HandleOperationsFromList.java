package core.basesyntax.dao;

import java.util.List;
import java.util.Map;

public interface HandleOperationsFromList {
    Map<String, Integer> getMapReport(List<String> stringList,
                                      Map<Operation, FruitOperation> operationMap);
}
