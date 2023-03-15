package core.basesyntax.service;

import core.basesyntax.exception.FruitShopException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterService {
    public void writeInFile(String fileName, String message) {
        File file = new File(fileName);
        try {
            Files.writeString(Path.of(fileName), message);
        } catch (IOException e) {
            throw new FruitShopException("Can`t write in file!");
        }
    }
}
