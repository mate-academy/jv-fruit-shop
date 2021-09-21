package core.basesyntax.dao;

import static core.basesyntax.db.Storage.storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class ActivitiesDaoCsvImpl implements ActivitiesDao {

    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String REGEX = ",";

    @Override
    public List<String> getActivities(String pathToFile) {
        try {
            return Files.readAllLines(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException("can't read from file " + pathToFile, e);
        }
    }

    @Override
    public void writeInFile(String pathToFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile))) {
            bufferedWriter.write(FRUIT + REGEX + QUANTITY + System.lineSeparator());
            for (Map.Entry<String, Integer> entry : storage.entrySet()) {
                bufferedWriter.write(entry.getKey() + REGEX
                        + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("can't write into file " + pathToFile, e);
        }

    }
}
