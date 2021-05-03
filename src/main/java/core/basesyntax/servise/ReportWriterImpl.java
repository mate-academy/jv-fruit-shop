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
    private static final String NAME_OF_COLUMNS = "fruit,quantity";
    private static final String COMA = ",";

    @Override
    public void writeReport(String fileName) {
        File newFile = new File(fileName);
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(newFile, true))) {
            bufferedWriter.write(NAME_OF_COLUMNS + System.lineSeparator());
            for (Map.Entry<Fruit, Integer> entry : Storage.getAll().entrySet()) {
                String line = entry.getKey().getTypeOfFruit() + COMA + entry.getValue()
                        + System.lineSeparator();
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't found the file", e);
        }
    }
}
