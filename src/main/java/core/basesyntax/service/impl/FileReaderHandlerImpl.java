package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.MyFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderHandlerImpl implements MyFileReader {
    @Override
    public void readFromFile(String fileName) {
        File readFromFile = new File(fileName);
        FruitTransaction fruitTransaction = new FruitTransaction();
        try (BufferedReader reader = new BufferedReader(new FileReader(readFromFile))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] pair = line.split(",");
                System.out.println(Arrays.toString(pair));
                fruitTransaction.setOperation(pair[0]);
                fruitTransaction.setFruit(pair[1]);
                fruitTransaction.setQuantity(Integer.parseInt(pair[2]));
                Storage.dataFromFile.add(fruitTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + readFromFile, e);
        }
    }
}
