package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeFile(String filePath, String content) {
        File file = new File(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath())) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file: " + filePath, e);
        }
    }
}
