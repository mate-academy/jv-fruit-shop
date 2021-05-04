package core.basesyntax.countingoperations;

import core.basesyntax.operationswithfile.Transaction;
import java.util.List;
import java.util.Map;

public class CountOperationImpl implements CountOperation {
    @Override
    public Map<String, Integer> getCount(Map<String, Integer> balance,
                                             List<Transaction> transactionList) {
        OperationsStrategy operationsStrategy = new OperationsStrategyImpl();
        for (Map.Entry<String, Integer> entry : balance.entrySet()) {
            for (int i = 0; i < transactionList.size(); i++) {
                if (entry.getKey().equals(transactionList.get(i).getName())) {
                    if ((entry.getValue()
                            + operationsStrategy.getStrategy(transactionList.get(i))) < 0) {
                        throw new RuntimeException("Unable to complete the operation: "
                                + transactionList.get(i).toString());
                    } else {
                        entry.setValue(entry.getValue()
                                + operationsStrategy.getStrategy(transactionList.get(i)));
                    }
                }
            }

        }
        return balance;
    }
}
