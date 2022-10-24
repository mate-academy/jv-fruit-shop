package core.basesyntax.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.operation.OperationType;
import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final int TYPE_COLUMN = 0;
    private static final int FRUIT_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;
    private static final int TITLE_LINE = 1;

    @Override
    public List<FruitRecordDto> read(String path) {
        List<FruitRecordDto> fruitRecords = new ArrayList<>();
        try {
            Files.readAllLines(Path.of(path)).stream()
                    .skip(TITLE_LINE)
                    .forEach(line -> {
                        String[] splitLine = line.split(",");
                        Fruit fruit = Fruit.builder().name(splitLine[FRUIT_COLUMN]).build();
                        fruitRecords.add(FruitRecordDto.builder()
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
