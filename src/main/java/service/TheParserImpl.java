package service;

import dto.Transaction;

public class TheParserImpl implements TheParser {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int EXPECTED_ELEMENTS = 3;

    @Override
    public Transaction parseLine(String dataline) {
        String[] parsedLine = dataline.split(COMMA);
        if ((parsedLine.length == EXPECTED_ELEMENTS)
                || (Integer.parseInt(parsedLine[QUANTITY_INDEX])) > 0
                || parsedLine[OPERATION_INDEX].matches("bspr")) {
            return new Transaction(parsedLine[OPERATION_INDEX],
                    parsedLine[FRUIT_INDEX],
                    Integer.parseInt(parsedLine[QUANTITY_INDEX]));
        }
        throw new RuntimeException("Incorrect input data");
    }
}
