package core.basesyntax.service.impl;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public String readFile(String fromFileName) {
        if (fromFileName == null || fromFileName.isEmpty()) {
            throw new FruitShopException("Enter correct file path");
        }
        try {
            return Files.readString(Paths.get(fromFileName));
        } catch (IOException e) {
            throw new FruitShopException("Can`t find this file " + fromFileName);
        }
    }
}
