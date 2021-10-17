package core.basesyntax.dao;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FruitDaoCSVImpl implements FruitDao {
    private String csvFileName;

    public FruitDaoCSVImpl(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    @Override
    public List<String> get() {
        File csvFile = new File(csvFileName);
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFile))) {
            return csvReader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read such csv-file: " + csvFileName, e);
        }
    }
}
