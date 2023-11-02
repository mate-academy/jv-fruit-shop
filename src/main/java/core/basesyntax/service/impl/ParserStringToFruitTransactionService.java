package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserStringToFruitTransactionService implements Parser {
    private static final String CANT_WRITE_EXCEPTION_MESSAGE = "can't parse this line";
    private static final String SPLITER = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fileData) {
        List<FruitTransaction> fruits = new ArrayList<>();
        for (String line : fileData) {
            String[] splitedLine = line.split(SPLITER);
            for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
                if (operation.getCode().equals(splitedLine[INDEX_OF_OPERATION])) {
                    fruits.add(new FruitTransaction(operation,
                            splitedLine[INDEX_OF_FRUIT_NAME],
                            Integer.parseInt(splitedLine[INDEX_OF_QUANTITY])));
                }
            }
        }
        return fruits;
    }
}
