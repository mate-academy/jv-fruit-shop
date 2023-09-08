package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidDataException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderServiceCsvImpl implements ReaderService {
    private static final String SPLIT_DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .skip(1)
                    .map(this::getFruitTransaction)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            throw new RuntimeException("Can't find file by path: " + filePath, ex);
        }
    }

    private FruitTransaction getFruitTransaction(String record) {
        String[] transaction = record.split(SPLIT_DELIMITER);
        Operation operation = getOperation(record, transaction[OPERATION_INDEX]);
        int quantity = Integer.parseInt(transaction[QUANTITY_INDEX]);
        if (quantity < 0) {
            throw new InvalidDataException("Quantity can't be negative value: " + record);
        }
        return new FruitTransaction(operation, transaction[FRUIT_NAME_INDEX], quantity);
    }

    private Operation getOperation(String record, String operationType) {
        return Operation
                .getByCode(operationType)
                .orElseThrow(() -> new InvalidDataException(
                        "File has invalid operation type: " + record)
                );
    }
}
