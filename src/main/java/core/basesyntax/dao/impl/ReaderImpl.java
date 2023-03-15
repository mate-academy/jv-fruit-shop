package core.basesyntax.dao.impl;

import core.basesyntax.dao.Reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<String> readDataFromFile(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Invalid path to the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file" + file, e);
        }
    }
}
