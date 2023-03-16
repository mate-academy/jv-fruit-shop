package core.basesyntax.service;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.service.interfaces.CsvFileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeInFile(String fileName, String message) {
        File file = new File(fileName);
        try {
            Files.writeString(Path.of(fileName), message);
        } catch (IOException e) {
            throw new FruitShopException("Can`t write in file!");
        }
    }
}
