package core.basesyntax.service.impl;

import core.basesyntax.service.ContentReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ContentReaderImpl implements ContentReader {
    private static final String RESOURCES_PATH = "src" + File.separator + "main" + File.separator
            + "resources" + File.separator;

    @Override
    public List<String> read(String fileName) {
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(RESOURCES_PATH + fileName)));
        } catch (IOException e) {
            throw new RuntimeException("File not found " + fileName);
        }
    }
}
