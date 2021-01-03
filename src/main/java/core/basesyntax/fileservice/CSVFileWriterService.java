package core.basesyntax.fileservice;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CSVFileWriterService implements FileWriterService {
    @Override
    public void writeToFile(Map<String, Integer> balance, String filePath) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(filePath)))) {
            for (Map.Entry<String, Integer> entry : balance.entrySet()) {
                csvWriter.writeNext(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
