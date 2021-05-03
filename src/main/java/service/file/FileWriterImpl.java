package service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String filename, String data) {
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException exception) {
            throw new RuntimeException("Can't create file");
        }
        try {
            Files.write(file.toPath(), data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException exception) {
            throw new RuntimeException("Cant write to file");
        }
    }
}
