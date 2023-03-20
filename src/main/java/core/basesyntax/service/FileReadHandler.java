package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReadHandler {
    public List<FruitTransaction> readFromFile(String file) {
        List<FruitTransaction> dataFromFile = new ArrayList<>();
        File readFromFile = new File(file);
        FruitTransaction fruitTransaction = new FruitTransaction();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input.csv"))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] pair = line.split(",");
                System.out.println(Arrays.toString(pair));
                fruitTransaction.setOperation(pair[0]);
                fruitTransaction.setFruit(pair[1]);
                fruitTransaction.setQuantity(Integer.parseInt(pair[2]));
                dataFromFile.add(fruitTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + readFromFile, e);
        }
        return dataFromFile;
    }
}
