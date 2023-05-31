package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {
    private static final int INFORMATION_LINES_COUNT = 1;
    private static final String COMMA_SEPARATOR = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> lines) {
        return lines.stream()
                .skip(INFORMATION_LINES_COUNT)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        String[] data = line.split(COMMA_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        if (data[TYPE_INDEX].equals(FruitTransaction.Operation.BALANCE.getCode())) {
            fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        } else if (data[TYPE_INDEX].equals(FruitTransaction.Operation.SUPPLY.getCode())) {
            fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
        } else if (data[TYPE_INDEX].equals(FruitTransaction.Operation.PURCHASE.getCode())) {
            fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
        } else if (data[TYPE_INDEX].equals(FruitTransaction.Operation.RETURN.getCode())) {
            fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        }
        fruitTransaction.setFruit(data[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(data[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
