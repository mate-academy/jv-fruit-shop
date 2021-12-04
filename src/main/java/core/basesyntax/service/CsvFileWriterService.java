package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterService {

    public CsvFileWriterService(String filename) {
        File file = new File("src" + File.separator + "main"
                + File.separator + "resources" + File.separator + filename);
        File fileAbsolutePath = new File(file.getAbsolutePath());

        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(fileAbsolutePath, true))) {
            bufferedWriter.write("fruit,quantity" + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }

        for (Fruit fruit1 :Storage.fruits) {
            try (BufferedWriter bufferedWriter =
                         new BufferedWriter(new FileWriter(fileAbsolutePath, true))) {
                bufferedWriter.write(fruit1.getNameFruit() + ","
                        + fruit1.getQuantityFruit() + "\n");
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file", e);
            }
        }
    }
}
