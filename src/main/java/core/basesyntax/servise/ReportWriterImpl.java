package core.basesyntax.servise;

import core.basesyntax.model.Fruit;
import core.basesyntax.servise.inrterfase.ReportWriter;
import core.basesyntax.storage.Storage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeReport(String fileName) {
        File newFile = new File(fileName);
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(newFile, true))) {
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<Fruit, Integer> entry : Storage.getAll().entrySet()) {
                String line = entry.getKey().getTypeOfFruit() + "," + entry.getValue()
                        + System.lineSeparator();
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't found the file", e);
        }
    }
}
