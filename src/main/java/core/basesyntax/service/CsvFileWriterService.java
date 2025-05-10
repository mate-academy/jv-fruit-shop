package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterService {

    public CsvFileWriterService(String filename, String report) {
        File fileAbsolutePath = new File(new File(filename).getAbsolutePath());

        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(fileAbsolutePath, true))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
