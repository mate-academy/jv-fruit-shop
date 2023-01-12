package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFileImpl implements FileReaderService {
    @Override
    public String readFile(String fromFileName) {
        try {
            return Files.readString(Paths.get(fromFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t find this file " + fromFileName, e);
        }
    }
}
