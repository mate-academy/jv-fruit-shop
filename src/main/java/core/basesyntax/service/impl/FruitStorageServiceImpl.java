package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operations;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FruitStorageService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitStorageServiceImpl implements FruitStorageService {
    private static final String SPLITTER = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final int FIELDS_QUANTITY = 3;
    private final OperationStrategy operationStrategy;
    private final ValidateOperationImpl validation = new ValidateOperationImpl();
    private final FileReader file = new ReadFromCsvFileImpl();
    private List<String> data = new ArrayList<>();

    public FruitStorageServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveFruitToStorage(String path) {
        data = file.read(path);
        for (String row: data) {
            String[] lineData = row.split(SPLITTER);
            if (lineData.length < FIELDS_QUANTITY
                    || !Operations.contains(lineData[OPERATION])) {
                throw new RuntimeException("Incorrect data");
            }
            Fruit fruit = new Fruit(lineData[FRUIT]);
            validation.validate(fruit, Integer.parseInt(lineData[AMOUNT]));
            operationStrategy.get(Operations.valueOf(lineData[OPERATION].toUpperCase()))
                    .apply(fruit, Integer.parseInt(lineData[AMOUNT]));
        }
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry: Storage.getStorage().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey().getName()).append(SPLITTER).append(entry.getValue());
        }
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry: Storage.getStorage().entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey().getName()).append(SPLITTER).append(entry.getValue());
        }
        return report.toString();
    }
}
