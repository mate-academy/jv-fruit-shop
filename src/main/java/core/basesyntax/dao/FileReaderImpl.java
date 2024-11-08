package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public String[] read(String nameOfFile) {
        List<String> textInFile = null;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(nameOfFile))) {
            textInFile = Files.readAllLines(Path.of(nameOfFile));
            return textInFile.stream()
                    .filter(i -> i.startsWith("b") || i.startsWith("s")
                    || i.startsWith("p") || i.startsWith("r"))
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the data from the file " + nameOfFile, e);
        }
    }
}
