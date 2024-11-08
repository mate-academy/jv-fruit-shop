package core.basesyntax.service.impl;

import core.basesyntax.model.AbstractTransaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.CsvReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class CsvReaderServiceImpl implements CsvReaderService<Fruit> {
    private static final String DELIMITER = ",";
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_COUNT = 2;

    @Override
    public List<AbstractTransaction<Fruit>> parse(String filePath) {
        return readLines(filePath).skip(1).map(this::parseLine).toList();

    }

    private Stream<String> readLines(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            return new BufferedReader(fileReader).lines();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + filePath, e);
        }
    }

    private AbstractTransaction<Fruit> parseLine(String line) {
        String[] tokens = line.split(DELIMITER);
        return new FruitTransaction(
                parseFruit(tokens[INDEX_OF_FRUIT]),
                Integer.parseInt(tokens[INDEX_OF_COUNT]),
                parseOperationType(tokens[INDEX_OF_OPERATION_TYPE])
        );
    }

    private Fruit parseFruit(String fruit) {
        return Fruit.valueOf(fruit.toUpperCase());
    }

    private OperationType parseOperationType(String operationType) {
        return switch (operationType) {
            case "b" -> OperationType.BALANCE;
            case "s" -> OperationType.SUPPLY;
            case "p" -> OperationType.PURCHASE;
            case "r" -> OperationType.RETURN;
            default -> throw new IllegalArgumentException(
                    "Unknown operation type: " + operationType);
        };
    }
}
