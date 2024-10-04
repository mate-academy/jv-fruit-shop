package fruitshop.service.impl;

import fruitshop.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String filePath) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(
                file))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException("can't write to file " + filePath, e);
        }

    }
}
