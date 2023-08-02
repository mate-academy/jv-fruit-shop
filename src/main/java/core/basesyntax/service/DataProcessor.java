package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.OperationNotFoundException;
import core.basesyntax.model.Operation;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.Map;
import java.util.Set;

public class DataProcessor {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COMA_SPLITTER = ",";
    private static final String HEAD_OF_THE_OUTPUT_FILE = "fruit,quantity" + LINE_SEPARATOR;
    private static final int INDEX_OF_OPERATIONS_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int INDEX_OF_BEGINNING_OF_DATA = 1;
    private final OperationStrategy operationStrategy;

    public DataProcessor(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public String processData(String dataFromFile) {
        String[] data = dataFromFile.split(LINE_SEPARATOR);
        for (int i = INDEX_OF_BEGINNING_OF_DATA; i < data.length; i++) {
            addFruitsToStorage(data[i]);
        }
        return generateRapport();
    }

    private void addFruitsToStorage(String record) {
        String[] splittedRecord = record.split(COMA_SPLITTER);
        operationStrategy
                .getOperationHandler(getOperationType(splittedRecord[INDEX_OF_OPERATIONS_TYPE]))
                .processData(
                        splittedRecord[INDEX_OF_FRUIT_TYPE],
                        Integer.parseInt(splittedRecord[INDEX_OF_QUANTITY]));
    }

    private Operation getOperationType(String operationTypeSymbol) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(operationTypeSymbol)) {
                return operation;
            }
        }
        throw new OperationNotFoundException("Invalid operation type: " + operationTypeSymbol);
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
