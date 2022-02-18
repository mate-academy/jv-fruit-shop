package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReportReaderServiceImpl implements ReportReaderService {
    private static final String SEPARATOR = ",";
    private static final int INDEX_MARKING_OPERATION = 0;
    private static final int INDEX_NAME_OF_FRUIT = 1;
    private static final int INDEX_QUANTITY_OF_FRUIT = 2;

    @Override
    public List<FruitTransaction> readFile(String filePath) {
        List<String> inputReport;
        try {
            inputReport = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file" + filePath);
        }
        return inputReport.stream()
                .skip(1)
                .map(this::getDataLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction getDataLine(String line) {
        String[] field = line.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .fromOperation(field[INDEX_MARKING_OPERATION]));
        fruitTransaction.setFruit(new Fruit(field[INDEX_NAME_OF_FRUIT]));
        fruitTransaction.setQuantity(Integer.parseInt(field[INDEX_QUANTITY_OF_FRUIT]));
        return fruitTransaction;
    }
}
