package core.basesyntax.services;

import core.basesyntax.dao.FruitDaoCsvImpl;
import core.basesyntax.exception.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadDataImp implements ReadData {
    private final FruitDaoCsvImpl fruitDaoCsv;

    public ReadDataImp(FruitDaoCsvImpl fruitDaoCsv) {
        this.fruitDaoCsv = fruitDaoCsv;
    }

    @Override
    public List<String> read() {
        List<String> strings;
        try {
            strings = Files.readAllLines(Path.of(String.valueOf(fruitDaoCsv.get())));
        } catch (IOException e) {
            throw new ValidationException("Can't get data from file");
        }
        return strings;
    }
}
