package service.impl;

import java.io.File;
import java.io.IOException;
import service.Writer;

public class FileWriter implements Writer {
    @Override
    public void writeToFile(String fileName, String content) {
        File file = new File(fileName);
        if (file.exists() && file.length() == 0) {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (java.io.FileWriter writer = new java.io.FileWriter(fileName);) {
            writer.write("fruit,quantity");
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }
}
