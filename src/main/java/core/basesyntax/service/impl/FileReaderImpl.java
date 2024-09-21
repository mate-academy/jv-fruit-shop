package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    public List<String> read(String fileName) {
        if (fileName == null) {
            throw new RuntimeException("Please, fill the correct file name.");
        }
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName,e);
        }
        return lines;
    }
}
