package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String text, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            if (text.isEmpty()) {
                throw new RuntimeException("Text can't be empty");
            }
            bufferedWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can't write text to file: " + filePath, e);
        }

    }
}
