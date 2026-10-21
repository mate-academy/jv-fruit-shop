package core.basesyntax.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterForFileImpl implements WriterForFile {
    @Override
    public void write(String data, String fileName) {
        String filePath = "src/main/java/" + fileName;
        File file = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + filePath, e);
        }
    }
}
