package core.basesyntax.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterService {

    public void writeLinesToFile(String fileName, String report) {
        try {
            Files.write(Paths.get(fileName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Got problem with write of file [" + fileName + "]");
        }
    }
}
