package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderImpl implements Reader {

    @Override
    public List<String> convertFromFileToList(String path) {
        List<String> information;
        try {
            information = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Wrong file name:" + path, e);
        }
        return information;
    }
}
