package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;

public class ParserImpl implements Parser {
    private static final int INDEX_OF_TYPE = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public TransactionDto parseLine(String line) {
        String[] arrayStringLine = line.split(",");
        String abbreviationActivityType = arrayStringLine[INDEX_OF_TYPE];
        String fruitName = arrayStringLine[INDEX_OF_FRUIT_NAME];
        int quantity = Integer.parseInt(arrayStringLine[INDEX_OF_QUANTITY]);
        return new TransactionDto(abbreviationActivityType, fruitName, quantity);
    }
}
