package core.basesyntax.dao;

import core.basesyntax.exception.ValidationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitDaoCsvImpl implements FruitDao {
    private final String fileName;

    public FruitDaoCsvImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> getData() {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(String.valueOf(new File(fileName))));
        } catch (IOException e) {
            throw new ValidationException("Can't get data from file");
        }
        return dataFromFile;
    }
}
