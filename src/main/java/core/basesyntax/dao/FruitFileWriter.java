package core.basesyntax.dao;

import core.basesyntax.exceptions.NullFileNameException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FruitFileWriter implements FruitDataWriter {
    private final String storageOutput;
    private final String fileName;

    public FruitFileWriter(String storageOutput, String fileName) {
        this.storageOutput = storageOutput;
        if (fileName == null) {
            throw new NullFileNameException("Can't write in a file with NULL name");
        }
        this.fileName = fileName;
    }

    @Override
    public void write() {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(fileName))) {
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            bufferedWriter.write(storageOutput);
        } catch (IOException e) {
            throw new RuntimeException("Can't write in the file " + fileName, e);
        }
    }
}
