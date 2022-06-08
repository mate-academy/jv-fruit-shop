package core.basesyntax.service.impl;

import core.basesyntax.service.DataValidator;
import core.basesyntax.service.MyFileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MyFileReaderImpl implements MyFileReader {
    private DataValidator dataValidator = new DataValidatorImpl();

    public List<String> readFromFile(String pathToFile) {
        File file = new File(pathToFile);
        List<String> info;
        try {
            info = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Could not assess the file", e);
        }
        return info;
    }
}
