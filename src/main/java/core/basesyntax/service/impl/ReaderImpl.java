package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderImpl implements Reader {
    private static final int SKIP_FIRST_LINE = 1;

    @Override
    public List<String> read(String fileName) {
        List<String> informationFromFile;
        try {
            informationFromFile = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file." + fileName);
        }
        return informationFromFile.stream().skip(SKIP_FIRST_LINE).collect(Collectors.toList());
    }
}
