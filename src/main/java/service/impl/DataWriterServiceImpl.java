package service.impl;

import db.Storage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import service.DataWriterService;

public class DataWriterServiceImpl implements DataWriterService {

    private static final String LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "fruit,quantity";

    @Override
    public void writeProcessedDataToFile(String filePath) {

        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(FILE_HEADER + LINE_SEPARATOR);
            for (Map.Entry<String, Integer> data : Storage.getFruitStorage().entrySet()) {
                bufferedWriter.write(data.getKey() + ","
                        + data.getValue() + LINE_SEPARATOR);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to this file: " + e);
        }
    }
}
