package core.basesyntax.model;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class FruitReportGenerator {
    private final OperationHandler operationHandler;

    public FruitReportGenerator() {
        operationHandler = new OperationHandler();
    }

    public String generateReport() {
        Map<String, Integer> fruitMap = new HashMap<>();
        for (FruitTransaction transaction : Storage.transactions) {
            String fruitName = transaction.getFruit().getName();
            int value = transaction.getQuantity();
            BinaryOperator<Integer> operator = operationHandler
                    .handleOperation(transaction.getOperation());
            int prevValue = fruitMap.getOrDefault(fruitName, 0);
            int result = operator.apply(prevValue, value);
            fruitMap.put(fruitName, result);
        }

        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            report.append(entry.getKey());
            report.append(",");
            report.append(entry.getValue());
            report.append(System.lineSeparator());
        }

        return report.toString();
    }
}
