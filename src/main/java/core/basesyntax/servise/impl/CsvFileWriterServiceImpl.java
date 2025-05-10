package core.basesyntax.servise.impl;

import core.basesyntax.servise.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String pathOutFile, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathOutFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + pathOutFile, e);
        }
    }
}
