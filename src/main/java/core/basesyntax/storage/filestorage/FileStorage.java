package core.basesyntax.storage.filestorage;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.model.MovementType;
import core.basesyntax.storage.DataBase;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileStorage extends DataBase {
    private static final String FILE_NAME = "src/main/resources/inputFileExample.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";
    private static final String REPORT_TOPIC = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final int TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_VALUE = 2;
    private static FileStorage instance;

    public static FileStorage getInstance() {
        if (instance == null) {
            instance = new FileStorage();
        }
        return instance;
    }

    {
        movementOfFruits = new ArrayList<>();
        init();
    }

    @Override
    public List<FruitMovement> getTransactionOf(Fruit fruit) {
        if (fruit == null) {
            throw new RuntimeException("Fruit can't be null");
        }
        return movementOfFruits.stream()
                .filter(fruitsMovement -> fruit.equals(fruitsMovement.getFruit()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fruit> getAllFruits() {
        return movementOfFruits.stream()
                .map(FruitMovement::getFruit)
                .collect(Collectors.toList());
    }

    @Override
    public void saveReport(Map<Fruit, Integer> results) {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_TOPIC).append(System.lineSeparator());
        for (Fruit fruit :results.keySet()) {
            builder.append(fruit).append(SEPARATOR).append(results.get(fruit));
            builder.append(System.lineSeparator());
        }
        builder.delete(builder.lastIndexOf(System.lineSeparator()), builder.length());
        writeToFile(builder.toString());
    }

    private void init() {
        List<String[]> input = readCsvFile();
        for (String[] record : input) {
            Fruit fruit = new Fruit(record[FRUIT_NAME]);
            MovementType type = getType(record[TYPE]);
            int value = Integer.parseInt(record[FRUIT_VALUE]);
            FruitMovement fruitMovement = new FruitMovement(fruit, type, value);
            movementOfFruits.add(fruitMovement);
        }
    }

    private static List<String[]> readCsvFile() {
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(FileStorage.FILE_NAME))
                .withSkipLines(1)
                .build()) {
            return csvReader.readAll();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + FILE_NAME, e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException("CSV library creates this exception.", e);
        }
    }

    private void writeToFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_FILE_NAME))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + REPORT_FILE_NAME, e);
        }
    }

    private static MovementType getType(String symbol) {
        switch (symbol) {
            case "b":
                return MovementType.BALANCE;
            case "s":
                return MovementType.SUPPLY;
            case "p" :
                return MovementType.PURCHASE;
            case "r":
                return MovementType.RETURN;
            default:
                throw new RuntimeException("The file contains wrong data."
                        + " First symbol can only be 'b','s','p' or 'r'");
        }
    }
}
