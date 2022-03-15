package core.basesyntax.dao;

import core.basesyntax.exceptions.NullFileNameException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FruitFileWriter implements DataWriter {
    @Override
    public void writeData(String storageOutput, String fileName) {
        if (fileName == null) {
            throw new NullFileNameException("Can't write in a file with NULL name");
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(fileName))) {
            bufferedWriter.write(storageOutput);
        } catch (IOException e) {
            throw new RuntimeException("Can't write in the file " + fileName, e);
        }
    }
}
