package mate.academy.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import mate.academy.service.ReadFile;

public class ReadFileImpl implements ReadFile {

    @Override
    public List<String> readFile(String pathName) {
        try {
            return Files.readAllLines(Path.of(pathName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from: " + pathName, e);
        }
    }
}
