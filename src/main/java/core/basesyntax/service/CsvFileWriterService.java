package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterService {

    public CsvFileWriterService(String filename) {
        resultWriter(filename);
    }

    private void resultWriter(String filename) {
        File fileAbsolutePath = new File(new File(filename).getAbsolutePath());

        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(fileAbsolutePath, true))) {
            bufferedWriter.write("fruit,quantity" + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }

        for (Fruit fruitOperation :Storage.fruits) {
            try (BufferedWriter bufferedWriter =
                         new BufferedWriter(new FileWriter(fileAbsolutePath, true))) {
                bufferedWriter.write(fruitOperation.getNameFruit() + ","
                        + fruitOperation.getQuantityFruit() + "\n");
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file", e);
            }
        }
    }
}
