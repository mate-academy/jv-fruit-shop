package core.basesyntax.service;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    public static final char CSV_SPLIT_BY = ',';

    @Override
    public boolean writeToFile(Map<String, Integer> stockBalance, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath),
                CSV_SPLIT_BY, '\0', ' ', "\n")) {
            String[] entries = {"fruit", "quantity"};
            writer.writeNext(entries);
            for (Map.Entry<String, Integer> entry : stockBalance.entrySet()) {
                String[] toFile = new String[]{entry.getKey(), String.valueOf(entry.getValue())};
                writer.writeNext(toFile);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException("The file cannot be written.", e);
        }
    }
}
