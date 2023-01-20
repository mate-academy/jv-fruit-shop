package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderCsvImpl implements Reader {
    @Override
    public List<String> readFromFile(String filePathname) {
        File file = new File(filePathname);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
    }
}
