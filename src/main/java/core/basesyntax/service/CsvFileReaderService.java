package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService {

    private static List<String> operations = new ArrayList<>();

    public CsvFileReaderService(String filename) {
        File file = new File("src" + File.separator + "main"
                + File.separator + "resources" + File.separator + filename);
        File fileAbsolutePath = new File(file.getAbsolutePath());
        try {
            operations = Files.readAllLines(fileAbsolutePath.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    public static List<String> getOperations() {
        return operations;
    }
}
