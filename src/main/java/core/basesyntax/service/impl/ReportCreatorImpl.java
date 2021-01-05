package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operations;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SPLITTER = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private final Storage storage;
    private final OperationStrategy operationStrategy;

    public ReportCreatorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        storage = new Storage();
    }

    @Override
    public String createReport(ReadFromCsvFileImpl file) {
        List<String> data = file.read();
        for (String row: data) {
            String[] lineData = row.split(SPLITTER);
            if (lineData.length < 3
                    || Integer.parseInt(lineData[AMOUNT]) < 0
                    || !Operations.contains(lineData[OPERATION])) {
                throw new RuntimeException("Incorrect data");
            }
            Fruit fruit = new Fruit(lineData[FRUIT]);
            operationStrategy.get(Operations.valueOf(lineData[OPERATION].toUpperCase()))
                    .apply(storage, fruit, Integer.parseInt(lineData[AMOUNT]));
        }
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry: storage.getStorage().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey().getName()).append(",").append(entry.getValue());
        }
        return report.toString();
    }
}
