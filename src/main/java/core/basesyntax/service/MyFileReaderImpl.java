package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReaderImpl implements MyFileReader {
    FruitTransaction fruitTransaction;
    @Override
    public void readFromFile(String fileName) {
        File readFromFile = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(readFromFile))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] pair = line.split(",");
                fruitTransaction = new FruitTransaction(pair[0],pair[1],Integer.parseInt(pair[2]));
                Storage.dataFromFile.add(fruitTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + readFromFile, e);
        }
    }
}
