package core.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterCsvImpl implements Writer {
    @Override
    public void writeData(String fileName, Map<String, Integer> value) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("fruit,quantity" + System.lineSeparator());
            
            for (Map.Entry<String, Integer> entry : value.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + fileName, e);
        }
    }
}
