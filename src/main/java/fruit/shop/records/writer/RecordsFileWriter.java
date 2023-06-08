package fruit.shop.records.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class RecordsFileWriter implements RecordsWriter {
    @Override
    public void writeRecords(String fileName, Map<String, Integer> records) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Integer> entry : records.entrySet()) {
                bufferedWriter.write(entry.getKey() + ","
                        + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong! Data wasn't written." + e);
        }
    }
}
