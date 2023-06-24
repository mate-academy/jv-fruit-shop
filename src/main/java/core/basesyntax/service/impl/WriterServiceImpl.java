package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeTextToFile(String text, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(text);
        } catch (Exception e) {
            throw new RuntimeException("error writing into the file", e);
        }
    }
}
