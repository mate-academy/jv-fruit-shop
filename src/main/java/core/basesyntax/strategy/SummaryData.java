package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummaryData {
    private static final int QUANTITY_ZERO = 0;

    public List<Transaction> getTotalResult(List<Transaction> transactions) {
        List<Transaction> listResult = new ArrayList<>();
        Map<String, List<Transaction>> mapGroupFruit = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getFruit));
        for (String key : mapGroupFruit.keySet()) {
            Transaction fruit = new Transaction(key, QUANTITY_ZERO);
            listResult.add(fruit);
        }
        for (Transaction totalResult : listResult) {
            for (Transaction transaction : transactions) {
                if (transaction.getFruit().equals(totalResult.getFruit())) {
                    processOperation(transaction.getOperation(),
                            totalResult, transaction.getQuantity());
                }
            }
        }
        return listResult;
    }

    public void processOperation(Operation operation,
                                 Transaction totalResult, int value) {
        totalResult.setQuantity(operation.getArithmeticOperation()
                .equals(Operation.ArithmeticOperation.ADD)
                ? Math.addExact(totalResult.getQuantity(), value)
                : Math.subtractExact(totalResult.getQuantity(), value));
    }
}
