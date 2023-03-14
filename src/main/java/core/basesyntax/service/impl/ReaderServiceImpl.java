package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/";

    public List<String> readFromFile(String fileName) {
        if (fileName == null || fileName.length() == 0) {
            throw new RuntimeException("File " + fileName + " is empty");
        }
        File file = new File(PATH_TO_INPUT_FILE + fileName);
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            lines.remove(0);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file",e);
        }
    }
}
