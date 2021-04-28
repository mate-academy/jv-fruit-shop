package service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String filename, String lineToWrite) {
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("can't create file");
        }
        try {
            Files.write(file.toPath(), lineToWrite.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("can't write to file");
        }
    }
}
