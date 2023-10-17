package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvFileWriterService implements WriterService {
    private final String fileName;
    private final List<String> fileData;

    public CsvFileWriterService(String fileName, List<String> fileData) {
        this.fileName = fileName;
        this.fileData = fileData;
    }

    @Override
    public void write() {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8))) {
            for (String csvLine : fileData) {
                bufferedWriter.write(csvLine);
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName, e);
        }
    }
}
