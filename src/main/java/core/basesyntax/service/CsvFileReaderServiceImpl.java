package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<FruitTransaction> readFromFile(String pathToFile) {
        List<String> lines;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't reaf from file: " + pathToFile, e);
        }
        return initialiseTransactionList(lines);
    }

    private List<FruitTransaction> initialiseTransactionList(List<String> fileLines) {
        return fileLines.stream()
                .filter(line -> {
                    for (FruitTransaction.Operation operation
                            : FruitTransaction.Operation.values()) {
                        if (line.startsWith(operation.getOperation())) {
                            return true;
                        }
                    }
                    return false;
                })
                .map(line -> new FruitTransaction(getConstantOfOperation(line.split(",")[0]),
                        Fruit.valueOf(line.split(",")[1].toUpperCase()),
                        Integer.parseInt(line.split(",")[2])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getConstantOfOperation(String operation) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(constant -> Objects.equals(constant.getOperation(), operation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("This operation doesn't exist"));
    }
}
