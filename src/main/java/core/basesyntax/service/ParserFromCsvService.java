package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParserFromCsvService {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "type,fruit,quantity";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> parse(List<String> file) {
        file = clearAnnotation(file);
        List<FruitTransaction> parsedTransaction = new ArrayList<>();

        for (String line : file) {
            String[] split = line.split(SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction
                    .Operation
                    .getOperationByCode(split[OPERATION_INDEX]));
            fruitTransaction.setFruit(split[FRUIT_TYPE_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(split[QUANTITY_INDEX]));
            parsedTransaction.add(fruitTransaction);
        }

        return parsedTransaction;
    }

    public List<String> clearAnnotation(List<String> file) {
        return file.stream()
                .filter(s -> !HEADER.equals(s))
                .collect(Collectors.toList());
    }
}
