package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.util.List;

public class FruitDaoCsvImpl implements FruitDao{
    public static final String FILE_NAME = "fruitdata.csv";

    @Override
    public List<String> get() {
        try {
            List<String> fruits = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + FILE_NAME, e);
        }
        return fr;
    }

    @Override
    public void add(String availableList) {

    }
}
