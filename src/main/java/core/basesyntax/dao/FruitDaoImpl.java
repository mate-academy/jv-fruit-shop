package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    private static final String SEPERATOR = ",";
    private static final String FILE_NAME =
            "C:\\Users\\IdeaProjects\\jv-fruit-shop"
                    + "\\src\\main\\java\\core\\basesyntax\\db\\database.csv";
    private static final String FILE_REPORT = "C:\\Users\\IdeaProjects\\jv-fruit-shop"
            + "\\src\\main\\java\\core\\basesyntax\\db\\report.csv";

    @Override
    public void addCsvRow(Fruit fruit) {
        String csvLine = toCsvString(fruit);
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)) {
            fileWriter.append(csvLine).append(System.lineSeparator());
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
    public void createReportCsv(List<String> transactions) {
        try (FileWriter fileWriter = new FileWriter(FILE_REPORT)) {

            fileWriter.append("fruit,quantity").append(System.lineSeparator());

            for (String transaction : transactions) {
                fileWriter.append(transaction).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create new CSV file " + FILE_REPORT, e);
        }
    }

    @Override
    public List<String> getReportCsv() {
        try {
            return Files.readAllLines(Path.of(FILE_REPORT));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + FILE_REPORT, e);
        }
    }

    private String toCsvString(Fruit fruitTransaction) {
        return fruitTransaction.getOperation().getCode() + SEPERATOR
                + fruitTransaction.getFruit() + SEPERATOR
                + fruitTransaction.getQuantity();
    }
}
