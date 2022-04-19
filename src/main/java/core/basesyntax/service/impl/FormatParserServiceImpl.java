package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FormatParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatParserServiceImpl implements FormatParserService {
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(String csvFormatData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] splittedDataBySeparator = csvFormatData.split(LINE_SEPARATOR);

        Arrays.stream(splittedDataBySeparator).skip(1)
                .map(e -> e.split(COMMA))
                .forEach(e -> fruitTransactions
                        .add(new FruitTransaction(FruitTransaction.Operation
                                .valueOfOperation(e[OPERATION_INDEX]),
                                new Fruit(e[FRUIT_INDEX]),
                                Integer.parseInt(e[QUANTITY_INDEX]))));

        return fruitTransactions;
    }
}
