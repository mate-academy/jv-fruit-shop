package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.Operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService{
    @Override
    public List<FruitTransaction> readFromString(String filePath) {
        if (filePath.length() == 0) {
            throw new RuntimeException("Can't get data from file " + filePath);
        }
        String[] fruits;
            fruits = filePath.split(System.lineSeparator());
        return Arrays.stream(fruits)
                .map(this::getFromString)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromString(String line){
        String[] fields = line.split(",");
        Operation operation = Operation.valueOf(fields[0].toUpperCase());
        Fruit fruit = Fruit.valueOf(fields[1].toUpperCase());
        int quantity = Integer.parseInt(fields[2]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
