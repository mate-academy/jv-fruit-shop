package core.basesyntax.service.parser;

import core.basesyntax.exception.ParseException;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class CsvParserImpl implements CsvParser {
    private static final String SPLITTER = ",";
    private static final int FRUIT_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> parseFruits(List<String> fileInfo) {
        List<FruitTransaction> fruits = new ArrayList<>();
        for (String string : fileInfo) {
            if (string.startsWith(HEADER)) {
                continue;
            }
            String[] strings = string.split(SPLITTER);
            FruitTransaction fruit = new FruitTransaction(getOperation(strings[FRUIT_TYPE_INDEX]),
                    strings[FRUIT_NAME_INDEX],
                    Integer.parseInt(strings[FRUIT_QUANTITY_INDEX]));
            fruits.add(fruit);
        }
        return fruits;
    }

    private FruitTransaction.Operation getOperation(String code) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new ParseException("Unknown operation code: " + code);
    }
}
