package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;

public class ParserServiceImpl implements ParserService {

    public static final String COMMA_SEPARATOR = ",";
    public static final int ACTIVITIES_INDEX = 0;
    public static final int FRUIT_NAME_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> linesFromFile) {
        try {
            return linesFromFile.stream()
                    .skip(1)
                    .map(this::getFromCsvRow)
                    .toList();
        } catch (NullPointerException e) {
            throw new RuntimeException("list cannot be null", e);
        }
    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(COMMA_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByCode(fields[ACTIVITIES_INDEX]));
        fruitTransaction.setFruit(fields[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
