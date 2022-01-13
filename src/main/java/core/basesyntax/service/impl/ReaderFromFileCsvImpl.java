package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderFromFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderFromFileCsvImpl implements ReaderFromFile {
    private static final String FIRST_LINE_TO_REMOVE = "type,fruit,quantity";

    @Override
    public List<String> read(File file) {
        List<String> listFromFile;
        try {
            listFromFile = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file! ", e);
        }
        listFromFile.remove(FIRST_LINE_TO_REMOVE);
        return listFromFile;
    }
}
