package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParseService;
import java.util.List;
import java.util.stream.Collectors;

public class FileParseServiceImpl implements FileParseService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseDataFromCV(List<String> dataFromFile) {
        return dataFromFile.stream()
                .map(line -> {
                    String[] parts = line.split(SEPARATOR);
                    String operationCode = parts[OPERATION_INDEX];
                    FruitTransaction.Operation operation = getOperation(operationCode);
                    String fruit = parts[FRUIT_INDEX];
                    int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperation(String code) {
        switch (code) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
                return FruitTransaction.Operation.RETURN;
            default:
                throw new IllegalArgumentException("Unknown operation code: " + code);
        }
    }
}
