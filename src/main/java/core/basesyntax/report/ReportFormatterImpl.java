package core.basesyntax.report;

import core.basesyntax.db.Storage;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.model.Fruit;
import core.basesyntax.workwithfiles.DataReader;
import java.util.List;
import java.util.Map;

public class ReportFormatterImpl implements ReportFormatter {
    private static final String HEAD_OF_REPORT = "fruit,quantity";
    private static final String SPLITTER = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private final Storage storage;
    private final OperationStrategy operationStrategy;

    public ReportFormatterImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        storage = new Storage();
    }

    @Override
    public String createReport(DataReader dataReader) {
        List<String> list = dataReader.readData();
        for (String row: list) {
            String[] data = row.split(SPLITTER);
            operationStrategy.get(Operations.valueOf(data[OPERATION].toUpperCase()))
                    .doOperation(new Fruit(data[FRUIT]), Integer.parseInt(data[AMOUNT]));

        }
        StringBuilder report = new StringBuilder(HEAD_OF_REPORT);
        for (Map.Entry<Fruit, Integer> entry: storage.getFruits().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey().getName()).append(SPLITTER).append(entry.getValue());
        }
        return report.toString();
    }
}
