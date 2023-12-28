package core.basesyntax.db;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportFileWriterImpl implements ReportFileWriter {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public void writeToFile(Map<String, Integer> fruitsStorage, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(HEADER + System.lineSeparator());
            for (String fruitName : fruitsStorage.keySet()) {
                if (fruitsStorage.get(fruitName) < 0) {
                    throw new RuntimeException("Total quantity for "
                            + fruitName + " is " + fruitsStorage.get(fruitName)
                    + " it can't be negative!");
                }
                if (fruitsStorage.get(fruitName) > 0) {
                    writer.write(fruitName + SEPARATOR
                            + fruitsStorage.get(fruitName) + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't access the file " + "\"" + filePath + "\"", e);
        }
    }
}
