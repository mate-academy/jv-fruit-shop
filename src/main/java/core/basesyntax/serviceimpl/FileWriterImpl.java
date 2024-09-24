package core.basesyntax.serviceimpl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeToFile(String fileName, String data) {
        try {
            Files.write(Paths.get(fileName), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file by path - " + fileName, e);
        }
    }
}
