package core.basesyntax.service;

import core.basesyntax.dto.Transaction;

public class ParserImpl implements Parser {

    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_REGEX = ",";
    private static final int COLUMNS_NUMBER = 3;

    @Override
    public Transaction parseLine(String line) {
        String[] splitLine = line.split(SPLIT_REGEX);
        if (splitLine.length != COLUMNS_NUMBER) {
            throw new RuntimeException("Invalid number of columns");
        }
        if (Integer.parseInt(splitLine[QUANTITY_INDEX]) < 0) {
            throw new RuntimeException("Quantity cannot be less than zero");
        }
        return new Transaction(splitLine[OPERATION_INDEX],
                splitLine[NAME_INDEX],
                Integer.parseInt(splitLine[QUANTITY_INDEX]));
    }
}
