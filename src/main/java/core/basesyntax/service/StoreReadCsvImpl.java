package core.basesyntax.service;

import core.basesyntax.model.Store;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StoreReadCsvImpl implements StoreReadCsv {

    @Override
    public Store read(String fileName) {
        List<String> fruits = new ArrayList<>();
        try {
            fruits = Files.readAllLines(Path.of(fileName));

        } catch (IOException e) {
            throw new RuntimeException("Can't find file");
        }
        return fruits
                .stream()
                .map(this::getFromCsv)
                .findFirst()
                .get();
    }

    private Store getFromCsv(String line) {
        String[] fields = line.split(",");
        Store fruit = new Store();
        fruit.setType(Store.Operation.valueOf(fields[0]));
        fruit.setName(fields[1]);
        fruit.setAmount(Integer.parseInt(fields[2]));
        return fruit;
    }
}
