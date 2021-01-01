package core.basesyntax.report;

import core.basesyntax.fruit.Fruits;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.reader.DataReader;
import core.basesyntax.reader.FileReader;

import java.util.List;
import java.util.Map;

public class ReportFormatterImpl implements ReportFormatter {
    private final Fruits fruits;
    private final OperationStrategy operationStrategy;

    public ReportFormatterImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        fruits = new Fruits();
    }

    @Override
    public String createReport(DataReader dataReader) {
        List<String> list = dataReader.readData();
        for (String row: list) {
            String[] data = row.split(",");
            if (Integer.parseInt(data[2]) < 0 || !Operations.contains(data[0])) {
                throw new RuntimeException("Incorrect data");
            }
            operationStrategy.get(Operations.valueOf(data[0].toUpperCase()))
                    .doOperation(fruits, data[1], Integer.parseInt(data[2]));

        }
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry: fruits.getFruits().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey()).append(",").append(entry.getValue());
        }
        return report.toString();
    }
}
