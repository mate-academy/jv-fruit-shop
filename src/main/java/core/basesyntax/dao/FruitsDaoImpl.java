package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitsDaoImpl implements FruitsDao{
    private static final String FILE_NAME = "fruitsData.csv";

    @Override
    public List<String> readFromFile() {
        try {
            return Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void writeToFile() {

    }

    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruit) {
        return Storage.fruits.stream()
                .filter(e -> e.getType().equals(fruit))
                .findFirst()
                .get();
    }
}