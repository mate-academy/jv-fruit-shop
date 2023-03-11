package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Validator;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static String WORDS_SEPARATOR = ",";
    
    @Override
    public TransactionDto parseLine(String line, Validator validator) {
        if (validator.validateLine(line)) {
            String[] fruitData = line.split(WORDS_SEPARATOR);
            return new TransactionDto(fruitData[OPERATION_INDEX],
                    fruitData[FRUIT_NAME_INDEX], Integer.parseInt(fruitData[QUANTITY_INDEX]));
        }
        return null;
    }
}
