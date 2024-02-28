package core.basesyntax.dao;

import core.basesyntax.entity.Fruit;
import core.basesyntax.entity.FruitTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StoreCsvDaoImpl implements StoreCsvDao {

    private static final String ACTIVITY_FILE_NAME = "resources\\dailyactivities.csv";
    private static final String REPORT_FILE_NAME = "resources\\dailyreport.csv";

    @Override
    public void add(Fruit fruit, int quantity) {

    }

    @Override
    public List<FruitTransaction> get(Fruit fruit, int quantity) {
        try {
            Files.readAllLines(Path.of(ACTIVITY_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<FruitTransaction> getAll() {
        return null;
    }

    @Override
    public void update(Fruit fruit, int quantity) {

    }

    @Override
    public void delete(Fruit fruit, int quantity) {

    }
}
