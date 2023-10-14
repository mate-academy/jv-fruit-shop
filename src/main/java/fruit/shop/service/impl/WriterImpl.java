package fruit.shop.service.impl;

import fruit.shop.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterImpl implements Writer {
    @Override
    public void writeToFile(String fileName, String content) {
        try {
            Files.writeString(Path.of(fileName), content);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + fileName,e);
        }
    }
}
