package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public void write(String outputData, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(HEADER);
            bufferedWriter.write(outputData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file" + fileName, e);
        }
    }
}
