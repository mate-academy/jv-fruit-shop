package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterService implements WriterService {
    @Override
    public void writeToFile(final String data, final String filePath) {
        File file = new File(filePath);
        try (
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("File " + e + " not found.");
        }
    }
}
