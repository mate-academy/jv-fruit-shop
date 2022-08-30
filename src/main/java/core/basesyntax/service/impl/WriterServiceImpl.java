package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    private static final String HEADERS = "fruit,quantity";

    @Override
    public void writeToFile(String fileName, String report) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            writeHeaders(bufferedWriter);
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file by path: " + fileName, e);
        }
    }

    private void writeHeaders(BufferedWriter bufferedWriter) {
        try {
            bufferedWriter.write(HEADERS + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't write headers to file", e);
        }
    }
}
