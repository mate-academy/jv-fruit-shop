package service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import service.Writer;

public class FileWriterImpl implements Writer {
    private static final String HEADER = "fruit,quantity";

    @Override
    public void writeToFile(String fileName, String content) {
        File file = new File(fileName);
        if (file.exists() && file.length() == 0) {
            file.delete();
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(HEADER);
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }
}
