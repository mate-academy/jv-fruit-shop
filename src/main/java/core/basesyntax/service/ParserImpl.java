package core.basesyntax.service;

import core.basesyntax.dto.Transaction;

public class ParserImpl implements Parser {
    private static final String COMMA = ",";
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;

    @Override
    public Transaction parse(String line) {
        String[] array = line.split(COMMA);
        return new Transaction(array[ZERO_INDEX],
                array[FIRST_INDEX], Integer.parseInt(array[SECOND_INDEX]));
    }
}
