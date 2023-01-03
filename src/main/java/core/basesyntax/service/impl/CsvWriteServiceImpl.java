package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvWriteServiceImpl implements WriteService {
    @Override
    public void writeReport(String path, String report) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(path))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + path, e);
        }
    }
}
