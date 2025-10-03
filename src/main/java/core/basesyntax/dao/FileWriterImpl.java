package core.basesyntax.dao;

import core.basesyntax.exception.FruitShopException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        if (data == null) {
            throw new FruitShopException("Data to write is null");
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName))) {
            writer.write(data);
        } catch (IOException e) {
            throw new FruitShopException("Can't write file: " + fileName, e);
        }
    }
}
