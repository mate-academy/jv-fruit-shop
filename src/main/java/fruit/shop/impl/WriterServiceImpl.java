package fruit.shop.impl;

import fruit.shop.service.writer.WriterService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeRecordsToFile(String fileName, Map<String, Integer> records) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Integer> entry : records.entrySet()) {
                bufferedWriter.write(entry.getKey() + ","
                        + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong! Can't write to file "
                    + fileName + " ! " + e);
        }
    }
}
