package mate.academy.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.model.FruitTransaction;
import mate.academy.service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String TITLE_OF_LINES = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .filter(l -> !l.equals(TITLE_OF_LINES))
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        if (Integer.valueOf(fields[INDEX_OF_QUANTITY]) < 0) {
            throw new RuntimeException("Quantity can't be less then zero.");
        }
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setFruit(fields[INDEX_OF_FRUIT]);
        fruitTransaction.setQuantity(Integer.valueOf(fields[INDEX_OF_QUANTITY]));
        fruitTransaction.setOperation(FruitTransaction.Operation
                .fromString(fields[INDEX_OF_OPERATION]));
        return fruitTransaction;
    }
}
