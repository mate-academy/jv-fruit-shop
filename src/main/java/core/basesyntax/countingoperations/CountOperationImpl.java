package core.basesyntax.countingoperations;

import core.basesyntax.operationswithfile.Operation;
import java.util.List;
import java.util.Map;

public class CountOperationImpl implements CountOperation {
    @Override
    public Map<String, Integer> getCount(Map<String, Integer> balance,
                                             List<Operation> operationList) {
        OperationsStrategy operationsStrategy = new OperationsStrategyImpl();
        for (Map.Entry<String, Integer> entry : balance.entrySet()) {
            for (int i = 0; i < operationList.size(); i++) {
                if (entry.getKey().equals(operationList.get(i).getName())) {
                    if ((entry.getValue()
                            + operationsStrategy.getStrategy(operationList.get(i))) < 0) {
                        throw new RuntimeException("Unable to complete the operation: "
                                + operationList.get(i).toString());
                    } else {
                        entry.setValue(entry.getValue()
                                + operationsStrategy.getStrategy(operationList.get(i)));
                    }
                }
            }

        }
        return balance;
    }
}
