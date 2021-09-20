package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.operation.OperationType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final int TYPE_COLUMN = 0;
    private static final int FRUIT_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;

    @Override
    public List<FruitRecord> read(String path) {
        List<FruitRecord> fruitRecords = new ArrayList<>();
        try {
            Files.readAllLines(Path.of(path)).stream()
                    .skip(1)
                    .forEach(line -> {
                        String[] splitLine = line.split(",");
                        Fruit fruit = Fruit.builder().name(splitLine[FRUIT_COLUMN]).build();
                        fruitRecords.add(FruitRecord.builder()
                                .type(OperationType.get(splitLine[TYPE_COLUMN]))
                                .fruit(fruit)
                                .amount(Integer.parseInt(splitLine[QUANTITY_COLUMN]))
                                .build());
                    });
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from file " + path);
        }
        return fruitRecords;
    }
}
