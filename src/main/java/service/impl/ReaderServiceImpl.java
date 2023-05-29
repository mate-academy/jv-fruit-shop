package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String TITLE = "type";
    private static final String COMA = ",";
    private static final int FIRST_POSITION_IN_LINE = 0;
    private static final int SECOND_POSITION_IN_LINE = 1;
    private static final int THIRD_POSITION_IN_LINE = 2;

    @Override
    public List<Fruit> readFromFile(String fileName) {
        List<String> fruit;
        try {
            fruit = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file " + fileName);
        }
        return fruit.stream()
                .filter(line -> !line.startsWith(TITLE))
                .map(this::getFruitFromCsvRow)
                .collect(Collectors.toList());
    }

    private Fruit getFruitFromCsvRow(String line) {
        String[] fields = line.split(COMA);
        Fruit fruit = new Fruit();
        fruit.setOperation(Fruit.Operation.getByCode(fields[FIRST_POSITION_IN_LINE]));
        fruit.setFruit(fields[SECOND_POSITION_IN_LINE]);
        fruit.setQuantity(Integer.parseInt(fields[THIRD_POSITION_IN_LINE]));
        return fruit;
    }
}
