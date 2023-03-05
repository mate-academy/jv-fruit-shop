package core.basesyntax.service.impl;

import core.basesyntax.service.ReadService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadServiceImpl implements ReadService {

    @Override
    public List<String> read(File file) {
        List<String> readAllLines = new ArrayList<>();
        try {
            readAllLines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + file, e);
        }
        return readAllLines;
    }
}
