package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReadFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFileServiceImpl implements ReadFileService {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<Fruit> readFile(String path) {
        List<String> informationAboutFruits = new ArrayList<>();
        try {
            informationAboutFruits = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + path, e);
        }
        return informationAboutFruits
                .stream()
                .map(line -> getFromCsv(line))
                .collect(Collectors.toList());
    }

    private Fruit getFromCsv(String line) {
        String[] fields = line.split(",");
        Fruit fruit = new Fruit();
        if (fields[INDEX_OPERATION].length() == 1) {
            fruit.setTypeOperation(Fruit.Operation.valueOfCode(fields[INDEX_OPERATION]));
            fruit.setTypeFruit(fields[INDEX_FRUIT]);
            fruit.setQuantity(Integer.parseInt(fields[INDEX_QUANTITY]));
        }
        return fruit;
    }
}
