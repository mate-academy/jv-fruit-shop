package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String FIRST_LINE = "fruit,quantity" + System.lineSeparator();

    @Override
    public void writeToFile(String path, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(FIRST_LINE);
            bufferedWriter.write(data);

        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to " + path, e);
        }
    }
}
