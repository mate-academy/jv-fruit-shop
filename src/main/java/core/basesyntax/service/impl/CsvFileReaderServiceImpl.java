package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final int ACTIVITY_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int NUMBER_INDEX = 2;
    private static final int HEAD_LINE = 1;

    @Override
    public List<FruitTransaction> readFromFile(String pathToFile) {
        List<String> inputData;
        File file = new File(pathToFile);
        try {
            inputData = Files.readAllLines(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file: " + file.getName(), e);
        }
        return inputData.stream().skip(HEAD_LINE).map(this::getData).collect(Collectors.toList());
    }

    public FruitTransaction getData(String data) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] info = data.split(",");
        fruitTransaction.setOperation(FruitTransaction
                .Operation.determineOperation(info[ACTIVITY_INDEX]));
        fruitTransaction.setFruit(info[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(info[NUMBER_INDEX]));

        return fruitTransaction;
    }
}
