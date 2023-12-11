package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TextFileWriter implements FileWriter{
    @Override
    public void writeToFile(String content, String filePath) {
        try {
            byte[] contentBytes = content.getBytes();

            Files.write(Path.of(filePath), contentBytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            System.out.println("Content successfully written to text file: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}
