package core.basesyntax.shop.service;

import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.Operation;
import core.basesyntax.shop.model.TransactionDto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReader implements FileReader {
    public static final int TYPE_COLUMN = 0;
    public static final int FRUIT_COLUMN = 1;
    public static final int QUANTITY_COLUMN = 2;

    @Override
    public List<TransactionDto> readData(String filePath) {
        try {
            return Files.lines(Path.of(filePath))
                    .filter(line -> !line.startsWith("type"))
                    .map(this::getFromCsvRow)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + filePath, e);
        }
    }

    private TransactionDto getFromCsvRow(String line) {
        String[] dataFromLine = line.split(",");
        if (dataFromLine.length < 3) {
            throw new IllegalArgumentException("File is broken!");
        }

        String operation = dataFromLine[TYPE_COLUMN];
        String fruitType = dataFromLine[FRUIT_COLUMN];
        int quantity = Integer.parseInt(dataFromLine[QUANTITY_COLUMN]);

        if (quantity < 0 || fruitType.isEmpty()) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        return new TransactionDto(Operation.fromString(operation), new Fruit(fruitType), quantity);
    }
}
