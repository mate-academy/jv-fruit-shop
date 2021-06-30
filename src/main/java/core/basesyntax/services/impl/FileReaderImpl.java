package core.basesyntax.services.impl;

import core.basesyntax.services.interfaces.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String EXCEPTION_MESSAGE = "Can't read file ";

    @Override
    public List<String> getLinesFromFile(String fileName) {
        String path = fileName;
        List<String> dataFromFile = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            try {
                dataFromFile = Files.readAllLines(Path.of(path));
            } catch (IOException e) {
                throw new RuntimeException(EXCEPTION_MESSAGE + e);
            }
        }
        return dataFromFile;
    }
}
