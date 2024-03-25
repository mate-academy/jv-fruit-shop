package core.basesyntax.service.impl;

import core.basesyntax.service.IFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderCvs implements IFileReader {

    @Override
    public List<String> read(String path) {
        List<String> lineList;
        try {
            lineList = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + path, e);
        }
        return lineList;
    }
}
