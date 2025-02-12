package service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.FruitTransaction;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    private final String filePath;

    public FileReaderImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> read(String fileName) throws FileNotFoundException {
        List<String> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            if (scanner.hasNext()) {
                scanner.nextLine();
            }
            while (scanner.hasNext()) {
                data.add(scanner.nextLine());
            }
        }
        return data;
    }

    @Override
    public FruitTransaction parseCsvRow(String csvRow) {
        String[] fields = csvRow.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.valueOf(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        try {
            fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity format: " + fields[2], e);
        }
        return fruitTransaction;
    }
}
