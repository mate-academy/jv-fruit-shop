package core.basesyntax.service;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.Operations;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FruitServiceImpl implements FruitService {
    private static OperationStrategy operationStrategy;
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveToStorage(List<String> data) {
        for (String line: data) {
            String[] splited = line.split(SPLITTER);
            if (Integer.parseInt(splited[QUANTITY_INDEX]) < 0) {
                throw new RuntimeException("negative value. You should chek your db");
            }
            operationStrategy.get(check(splited[OPERATION_INDEX]))
                    .doOperation(new Fruit(splited[FRUIT_INDEX]),
                            Integer.parseInt(splited[QUANTITY_INDEX]));
        }
    }

    @Override
    public String getReportFromStorage() {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<Fruit, Integer> entry : Storage.getFruitsMap().entrySet()) {
            report.append(System.lineSeparator()).append(entry.getKey().getName())
                    .append(SPLITTER).append(entry.getValue());
        }
        return report.toString();
    }

    private Operations check(String operation) {
        for (Operations current : Operations.values()) {
            if (Objects.equals(current.getOperation(), operation.toLowerCase().trim())) {
                return current;
            }
        }
        throw new RuntimeException("Wrong operation " + operation);
    }
}
