package core.basesyntax.service.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class CsvFileWriter implements FileWriter {
    private static final String EXCEPTION_MESSAGE = "Can't write to file";

    @Override
    public void writeToFile(String report, String path) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE, e);
        }
    }
}
