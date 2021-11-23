package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.WriterToFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterToFileImpl implements WriterToFile {
    @Override
    public void writeDataToFile(String pathToFile) {
        File file = new File(pathToFile);
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write("fruit,quantity\n");
        } catch (IOException e) {
            throw new RuntimeException("Can't write text to file", e);
        }
        for (Map.Entry<Fruit, Integer> fruit : Storage.getDataBase().entrySet()) {
            try {
                bufferedWriter.write(fruit.getKey().getFruitName() + ',' + fruit.getValue());
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file", e);
            }
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't close file", e);
        }
    }
}

