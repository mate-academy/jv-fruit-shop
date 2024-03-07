package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String pathToFile, String content) {
        File file = new File(pathToFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Can't make new file: " + pathToFile, e);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + pathToFile, e);
        }
    }
}
