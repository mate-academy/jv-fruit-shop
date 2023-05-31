package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    public static final int HEADER_LINE_INDEX = 0;

    @Override
    public List<String> readFile(String fileName) {
        try {
            List<String> list = Files.readAllLines(Path.of(fileName));
            list.remove(HEADER_LINE_INDEX);
            return list;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from this file " + fileName, e);
        }
    }
}
