package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private Map<String, OperationHandler> operationStrategyMap;

    public TransactionServiceImpl(Map<String, OperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public Map<String, Integer> handleTransactions(List<FruitTransaction> transactions) {
        Map<String, Integer> resultReport = new HashMap<>();
        for (int i = 0; i < transactions.size(); i++) {
            FruitTransaction transaction = transactions.get(i);
            if (resultReport.containsKey(transaction.getName())) {
                operationStrategyMap
                        .get(String.valueOf(transaction.getType()))
                        .handle(transaction);

                resultReport.put(transaction.getName(),
                        transaction.getAmount() + resultReport.get(transaction.getName()));
            } else {
                resultReport.put(transaction.getName(), transaction.getAmount());
            }
        }
        return resultReport;
    }
}
