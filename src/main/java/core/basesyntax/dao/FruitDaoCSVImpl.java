package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        try {
            return new BufferedReader(new FileReader(csvFile))
                    .lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such csv-file: " + csvFileName, e);
        }
    }
}
