package service.implement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public boolean write(String outputString, String filePath) {
        try {
            Files.writeString(Path.of(filePath), outputString);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file ", e);
        }
        return true;
    }
}
