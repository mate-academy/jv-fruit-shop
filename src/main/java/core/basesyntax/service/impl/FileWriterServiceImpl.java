package core.basesyntax.service.impl;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterServiceImpl implements FileWriterService {
    public void writeToFile(String report, String toFileName) {
        if (report == null || report.length() < 1) {
            throw new FruitShopException("String report should not be null or empty");
        }
        try {
            Files.writeString(Paths.get(toFileName), report);
        } catch (IOException e) {
            throw new FruitShopException("Can't find file " + toFileName);
        }
    }
}
