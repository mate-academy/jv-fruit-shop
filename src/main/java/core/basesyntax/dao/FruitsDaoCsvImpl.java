package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitsDaoCsvImpl implements FruitsDao {
    private static final String FROM_FILE_NAME = "fromFruits.csv";
    private static final String TO_FILE_NAME = "toFruits.csv";
    private static final File TO_FILE = new File(TO_FILE_NAME);
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";

    @Override
    public List<FruitTransaction> readDataFromFruitsCsv(String fromFileName) {
        List<String> fruits = new ArrayList<>();
        try {
            fruits = Files.readAllLines(Path.of(fromFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from CSV file " + FROM_FILE_NAME);
        }
        return fruits.stream()
                .filter(line -> line.contains(BANANA) || line.contains(APPLE))
                .map(line -> getInfoFromCsvRow(line.trim()))
                .collect(Collectors.toList());
    }

    @Override
    public void writeReportToCsvFile(String report) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(TO_FILE, true))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to CSV file " + TO_FILE_NAME);
        }
    }

    private FruitTransaction getInfoFromCsvRow(String line) {
        String[] fields = line.split(",");
        fields[0] = fields[0].toUpperCase();
        FruitTransaction fruitTransaction = new FruitTransaction();
        if (Operation.BALANCE.toString().startsWith(fields[0])) {
            fruitTransaction.setOperation(Operation.BALANCE);
        } else if (Operation.SUPPLY.toString().startsWith(fields[0])) {
            fruitTransaction.setOperation(Operation.SUPPLY);
        } else if (Operation.PURCHASE.toString().startsWith(fields[0])) {
            fruitTransaction.setOperation(Operation.PURCHASE);
        } else if (Operation.RETURN.toString().startsWith(fields[0])) {
            fruitTransaction.setOperation(Operation.RETURN);
        }
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }
}
