package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FruitDaocsv implements FruitDao {

    @Override
    public List<String> get(String fileName) {
        File csvFile = new File(fileName);
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFile))) {
            return csvReader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read such csv-file: " + fileName, e);
        }
    }
}
