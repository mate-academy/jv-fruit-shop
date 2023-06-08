package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String HEAD_OF_REPORT_TABLE = "fruit,quantity";
    private Map<Fruit, Integer> dailyReport = new HashMap<>();
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public List<String> processDailyReport(List<Transaction> transactionsList) {
        for (Transaction transaction : transactionsList) {
            Integer valueForAdd = operationStrategy.getOperationDirection(
                    transaction.getOperation()).applyOperation(transaction.getAmount());
            if (dailyReport.containsKey(transaction.getFruit())) {
                if (dailyReport.get(transaction.getFruit()) + valueForAdd < 0) {
                    throw new RuntimeException("Illegal daily report value for "
                            + transaction.getFruit().getFruitName()
                            + ". Total amount is negative.");
                }
                dailyReport.put(transaction.getFruit(),
                        dailyReport.get(transaction.getFruit()) + valueForAdd);
            } else {
                if (valueForAdd >= 0) {
                    dailyReport.put(transaction.getFruit(), valueForAdd);
                } else {
                    throw new RuntimeException("Illegal daily report value for "
                            + transaction.getFruit().getFruitName()
                            + ". Total amount is negative.");
                }
            }
        }
        return dailyReport.entrySet()
                .stream()
                .map(s -> s.getKey().toString().toLowerCase()
                        + DailyTransactionsStringToTransactions.SEPARATE_SYMBOL_FOR_CSV
                        + s.getValue())
                .collect(Collectors.toList());
    }

    public List<String> createReport(List<String> dailyBalanceList) {
        dailyBalanceList.add(0, HEAD_OF_REPORT_TABLE);
        return dailyBalanceList;
    }
}
