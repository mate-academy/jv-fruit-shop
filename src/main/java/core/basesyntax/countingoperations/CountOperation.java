package core.basesyntax.countingoperations;

import core.basesyntax.operationswithfile.Operation;
import java.util.List;
import java.util.Map;

public interface CountOperation {
    Map<String, Integer> getCount(Map<String, Integer> balance,
                                  List<Operation> operationList);
}
