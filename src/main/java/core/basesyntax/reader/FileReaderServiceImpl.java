package core.basesyntax.reader;

import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImpl implements FileReaderService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

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
        if (fields[OPERATION_INDEX].length() == 1) {
            fruit.setTypeOperation(Fruit.Operation.valueOfCode(fields[OPERATION_INDEX]));
            fruit.setTypeFruit(fields[FRUIT_INDEX]);
            fruit.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        }
        return fruit;
    }
}
