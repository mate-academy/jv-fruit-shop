package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private String readFromFile = "src"
            + File.separator + "main"
            + File.separator + "resources"
            + File.separator + "outputFile.csv";

    public String getReadFromFile() {
        return readFromFile;
    }

    public void setReadFromFile(String readFromFile) {
        this.readFromFile = readFromFile;
    }

    @Override
    public List<String> getLines() {
        File fileToPath = new File(readFromFile);
        try {
            return Files.readAllLines(fileToPath.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + e);
        }
    }
}
