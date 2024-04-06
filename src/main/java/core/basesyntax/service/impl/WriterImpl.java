package core.basesyntax.service.impl;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.service.Writer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterImpl implements Writer {
    @Override
    public void writeToFile(String inputFilePath, String report) {
        File file = new File(inputFilePath);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new FruitShopException("Can't write data to file by path " + inputFilePath);
        }
    }
}
