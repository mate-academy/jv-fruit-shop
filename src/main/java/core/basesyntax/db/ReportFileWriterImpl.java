package core.basesyntax.db;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportFileWriterImpl implements ReportFileWriter {
    private static final String SEPARATOR = ",";

    @Override
    public void writeToFile(Map<String, Integer> fruitsStorage, String filePath) {
        FileWriter writer;
        try {
            writer = new FileWriter(filePath);
            writer.write("fruit,quantity" + System.lineSeparator());
            for (String fruitName : fruitsStorage.keySet()) {
                if (fruitsStorage.get(fruitName) < 0) {
                    throw new RuntimeException("Quantity value can't be negative");
                }
                if (fruitsStorage.get(fruitName) > 0) {
                    writer.write(fruitName + SEPARATOR
                            + fruitsStorage.get(fruitName) + System.lineSeparator());
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file", e);
        }
    }
}

