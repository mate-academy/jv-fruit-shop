package core.basesyntax.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadDataFromFileCsvImpl implements core.basesyntax.service.ReadDataFromFile {
    private static final String FIRST_LINE = "type,fruit,quantity";

    @Override
    public List<String> readFromFile(File file) {
        List<String> listFromFile;
        try {
            listFromFile = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file! ", e);
        }
        listFromFile.remove(FIRST_LINE);
        return listFromFile;
    }
}
