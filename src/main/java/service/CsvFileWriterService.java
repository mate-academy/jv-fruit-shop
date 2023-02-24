package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriterService implements FileWriterService {

    @Override
    public File saveToFile(File reportFile, List<String> report) {
        report.forEach(l -> write(reportFile, l));
        return reportFile;
    }

    private void write(File reportFile, String line) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(reportFile, true))) {
            bufferedWriter.write(line + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can’t write data to file", e);
        }
    }
}
