package core.basesyntax.model;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperatorStrategy;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class FruitReportGenerator {
    private final OperatorStrategy operatorStrategy;

    public FruitReportGenerator() {
        operatorStrategy = new OperatorStrategy();
    }

    public String generateReport() {
        Map<String, Integer> fruitMap = new HashMap<>();
        for (FruitTransaction transaction : Storage.transactions) {
            String fruitName = transaction.getFruit().getName();
            int value = transaction.getQuantity();
            BinaryOperator<Integer> operator = operatorStrategy
                    .getOperator(transaction.getOperation());
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
