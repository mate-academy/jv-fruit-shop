package core.basesyntax.service.writer;

import static core.basesyntax.db.Storage.fruits;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterServiceCsvImpl implements WriterService {
    @Override
    public void writeToFile(String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            String result = "fruit,quantity" + System.lineSeparator();
            writer.write(result);
            for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
                result = entry.getKey() + "," + entry.getValue() + System.lineSeparator();
                writer.write(result);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write date to file: " + outputFile, e);
        }
    }
}
