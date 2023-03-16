package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.ParserFromCsvService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParserFromCsvServiceImpl implements ParserFromCsvService {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "type,fruit,quantity";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
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

    @Override
    public List<String> clearAnnotation(List<String> file) {
        return file.stream()
                .filter(s -> !HEADER.equals(s))
                .collect(Collectors.toList());
    }
}
