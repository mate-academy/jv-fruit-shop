package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String PATH_TO_FILE = "src/resources/";

    @Override
    public List<String> read(String fileName) {
        List<String> dataList = new ArrayList<>();
        File file = new File(PATH_TO_FILE + fileName);
        try {
            dataList = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName);
        }
        return dataList;
    }
}
