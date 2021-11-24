package service.implement;

import service.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {

    @Override
    public boolean write(String outputString, String pathTpOutputFile) {
        try {
            Files.writeString(Path.of(pathTpOutputFile), outputString);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file ", e);
        }
        return true;
    }
}
