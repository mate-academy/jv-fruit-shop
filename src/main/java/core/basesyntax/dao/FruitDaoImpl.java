package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    private static final String SEPARATOR = ",";
    private static final String FILE_NAME =
            "C:\\Users\\IdeaProjects\\jv-fruit-shop"
                    + "\\src\\main\\java\\core\\basesyntax\\db\\database.csv";

    @Override
    public void addCsvRow(Fruit fruit) {
        String csvLine = toCsvString(fruit);
        try {
            Files.write(Path.of(FILE_NAME), (csvLine
                    + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Failed to add data to file " + FILE_NAME, e);
        }
    }

    @Override
    public List<String> getCsv() {
        try {
            return Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + FILE_NAME, e);
        }
    }

    @Override
    public void updateCsv(List<String> updatedCsvData) {
        try {
            Files.write(Path.of(FILE_NAME), updatedCsvData);
        } catch (IOException e) {
            throw new RuntimeException("Can't update data in file " + FILE_NAME, e);
        }
    }

    private String toCsvString(Fruit fruitTransaction) {
        return fruitTransaction.getOperation().getCode() + SEPARATOR
                + fruitTransaction.getFruit() + SEPARATOR
                + fruitTransaction.getQuantity();
    }
}
