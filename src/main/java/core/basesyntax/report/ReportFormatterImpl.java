package core.basesyntax.report;

import core.basesyntax.fruit.Fruits;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.reader.DataReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportFormatterImpl implements ReportFormatter {
    private static final String SPLITTER = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
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
            String[] data = row.split(SPLITTER);
            if (Integer.parseInt(data[AMOUNT]) < 0 || !Operations.contains(data[OPERATION])) {
                throw new RuntimeException("Incorrect data");
            }
            operationStrategy.get(Operations.valueOf(data[OPERATION].toUpperCase()))
                    .doOperation(fruits, data[FRUIT], Integer.parseInt(data[AMOUNT]));

        }
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry: fruits.getFruits().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey()).append(",").append(entry.getValue());
        }
        return report.toString();
    }

    @Override
    public void createReportInFile(DataReader dataReader, String fileName) {
        String report = createReport(dataReader);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("File was not found");
        }
    }
}
