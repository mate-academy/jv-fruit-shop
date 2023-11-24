package shop.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import shop.service.FileWriterService;

public class CsvFileWriterService implements FileWriterService {
    private static final String COMMA_DELIMITER = ",";

    @Override
    public void writeToFile(String filePath, List<String[]> data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] datum : data) {
                String s = convertToCsv(datum);
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }

    public String convertToCsv(String[] data) {
        return String.join(COMMA_DELIMITER, data);
    }
}
