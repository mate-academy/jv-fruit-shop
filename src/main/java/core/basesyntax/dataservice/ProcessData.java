package core.basesyntax.dataservice;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.OperationNotFoundException;
import core.basesyntax.operationstrategy.Operation;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import java.util.Map;
import java.util.Set;

public class ProcessData {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COMA_SPLITTER = ",";
    private static final String HEAD_OF_THE_OUTPUT_FILE = "fruit,quantity" + LINE_SEPARATOR;
    private static final int indexOfOperationsType = 0;
    private static final int indexOfFruitType = 1;
    private static final int indexOfQuantity = 2;
    private final OperationStrategy operationStrategy = new OperationStrategyImpl();

    public String processData(String dataFromFile) {
        String[] data = dataFromFile.split(LINE_SEPARATOR);
        for (int i = 1; i < data.length; i++) {
            addFruitsToStorage(data[i]);
        }
        return generateRapport();
    }

    private void addFruitsToStorage(String record) {
        String[] splittedRecord = record.split(COMA_SPLITTER);
        operationStrategy
                .getOperationHandler(defineOperationType(splittedRecord[indexOfOperationsType]))
                .processData(
                        splittedRecord[indexOfFruitType],
                        Integer.parseInt(splittedRecord[indexOfQuantity]));
    }

    private Operation defineOperationType(String operationType) {
        switch (operationType) {
            case "b":
                return Operation.BALANCE;
            case "p":
                return Operation.PURCHASE;
            case "r":
                return Operation.RETURN;
            case "s":
                return Operation.SUPPLY;
            default:
                throw new OperationNotFoundException("Invalid operation type: " + operationType);
        }
    }

    private String generateRapport() {
        StringBuilder builder = new StringBuilder(HEAD_OF_THE_OUTPUT_FILE);
        Set<Map.Entry<String, Integer>> fruits = Storage.getStorage().entrySet();
        for (Map.Entry<String, Integer> fruit : fruits) {
            builder.append(fruit.getKey())
                    .append(COMA_SPLITTER)
                    .append(fruit.getValue())
                    .append(LINE_SEPARATOR);
        }
        return builder.toString();
    }
}
