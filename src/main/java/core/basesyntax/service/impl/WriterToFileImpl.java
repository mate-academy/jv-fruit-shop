package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.WriterToFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterToFileImpl implements WriterToFile {
    @Override
    public void writeDataToFile(String pathToFile) {

        for (Map.Entry<Fruit, Integer> fruit : Storage.getDataBase().entrySet()) {
            try (BufferedWriter bufferedWriter =
                         new BufferedWriter((new FileWriter(pathToFile,true)))) {
                bufferedWriter.write(fruit.toString());
                bufferedWriter.write("\n");
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file", e);
            }
        }
    }
}
