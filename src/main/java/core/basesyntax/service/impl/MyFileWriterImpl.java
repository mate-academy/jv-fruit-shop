package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDao;
import core.basesyntax.service.MyFileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MyFileWriterImpl implements MyFileWriter {
    public void writeToFile(String pathToFile) {
        File report = new File(pathToFile);
        try (BufferedWriter q = new BufferedWriter(new FileWriter(report))) {
            for (Map.Entry<String, Integer> entry : FruitDao.getStorage().entrySet()) {
                q.write(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not assess the file", e);
        }
    }
}
