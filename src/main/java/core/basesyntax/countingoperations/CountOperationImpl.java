package core.basesyntax.countingoperations;

import core.basesyntax.operationswithfile.Operation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountOperationImpl implements CountOperation {
    @Override
    public HashMap<String, Integer> getCount(HashMap<String, Integer> balance,
                                             ArrayList<Operation> operationArrayList) {
        OperationsStrategy operationsStrategy = new OperationsStrategyImpl();
        for (Map.Entry<String, Integer> entry : balance.entrySet()) {
            for (int i = 0; i < operationArrayList.size(); i++) {
                if (entry.getKey().equals(operationArrayList.get(i).getName())) {
                    if ((entry.getValue()
                            + operationsStrategy.getStrategy(operationArrayList.get(i))) < 0) {
                        throw new RuntimeException("Unable to complete the operation: "
                                + operationArrayList.get(i).toString());
                    } else {
                        entry.setValue(entry.getValue()
                                + operationsStrategy.getStrategy(operationArrayList.get(i)));
                    }
                }
            }

        }
        return balance;
    }
}
