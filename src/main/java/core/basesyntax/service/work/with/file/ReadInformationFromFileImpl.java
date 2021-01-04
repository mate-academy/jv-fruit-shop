
package core.basesyntax.service.work.with.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadInformationFromFileImpl implements ReadInformationFromFile {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getAllLines() {
        List<String> fruits;
        try {
            fruits = Files.readAllLines(Path.of(getFileName()));
        } catch (IOException e) {
            throw new RuntimeException("Cannot get data from file " + fileName);
        }
        return fruits;
    }
}

