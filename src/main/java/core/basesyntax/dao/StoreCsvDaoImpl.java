package core.basesyntax.dao;

import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.entity.Operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreCsvDaoImpl implements StoreCsvDao {

    private static final String ACTIVITY_FILE_NAME = "resources\\dailyactivities.csv";


    @Override
    public void add(FruitTransaction fruitTransaction) {

        String line = fruitTransaction.getOperation().getCode()
                + ","
                + fruitTransaction.getFruit()
                + ","
                + fruitTransaction.getQuantity()
                + System.lineSeparator();
        try {
            Files.writeString(Path.of(ACTIVITY_FILE_NAME), line);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write the data to file :" + ACTIVITY_FILE_NAME);
        }

    }

    @Override
    public List<FruitTransaction> getTransactionList(String transactionType) {
        List<String> allLines = new ArrayList<>();
        try {
             allLines = Files.readAllLines(Path.of(ACTIVITY_FILE_NAME));

        } catch (IOException e) {
            throw new RuntimeException("Cannot read the data from csv " + ACTIVITY_FILE_NAME);
        }
        return allLines.stream()
                .filter(line -> line.startsWith(transactionType))
                .map(this::getTransactionFromCsv)
                .collect(Collectors.toList());
    }

    @Override
    public List<FruitTransaction> getAll() {
        List<String> allLines = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Path.of(ACTIVITY_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the data from csv " + ACTIVITY_FILE_NAME);
        }
        return allLines.stream()
                .map(this::getTransactionFromCsv)
                .collect(Collectors.toList());
    }

    private FruitTransaction getTransactionFromCsv(String line) {
        String[] row = line.split(",");
        Operation operation = Operation.chooseOperation(row[0]);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(row[1]);
        fruitTransaction.setQuantity(Integer.parseInt(row[2]));
        return fruitTransaction;
    }

}
