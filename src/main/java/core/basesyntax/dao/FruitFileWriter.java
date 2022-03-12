package core.basesyntax.dao;

import core.basesyntax.exceptions.NullFileNameException;
import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FruitFileWriter implements FruitDataWriter {
    private final List<Fruit> fruits;
    private final String fileName;

    public FruitFileWriter(List<Fruit> fruits, String fileName) {
        this.fruits = fruits;
        if (fileName == null) {
            throw new NullFileNameException("Can't write in a file with NULL name");
        }
        this.fileName = fileName;
    }

    @Override
    public void write() {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(fileName))) {
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            bufferedWriter.write(createOutput());
        } catch (IOException e) {
            throw new RuntimeException("Can't write in the file " + fileName, e);
        }
    }

    private String createOutput() {
        return fruits.stream()
                .map(Fruit::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
