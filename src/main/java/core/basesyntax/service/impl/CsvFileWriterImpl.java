package core.basesyntax.service.impl;

import core.basesyntax.service.writer.CsvFileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void writeDataToFile(String filepath, String report) {
        File todayReport = new File(filepath);
        try {
            //noinspection ResultOfMethodCallIgnored
            todayReport.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Cannot create file " + filepath, e);
        }
        try {
            Files.write(Path.of(filepath), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file " + filepath, e);
        }
    }
}
