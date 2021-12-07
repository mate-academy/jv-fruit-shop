package core.basesyntax.service.filehandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileHandlerImpl implements FileHandler {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Invalid file name: " + fileName);
        }
        return data;
    }

    @Override
    public void writeToFile(String fileName, String data) {
        try (Writer writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Invalid file name: " + fileName);
        }
    }
}
