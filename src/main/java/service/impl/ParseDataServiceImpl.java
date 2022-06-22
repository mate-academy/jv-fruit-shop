package service.impl;

import service.ParseDataService;

public class ParseDataServiceImpl implements ParseDataService {
    private static final int TYPE_OF_OPERATION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int QUANTITY_OF_FRUITS = 2;
    private static final String CSV_SEPARATOR = ",";
    private String[] parsedData;

    @Override
    public String getOperation() {
        return parsedData[TYPE_OF_OPERATION];
    }

    @Override
    public String getTypeOfFruit() {
        return parsedData[TYPE_OF_FRUIT];
    }

    @Override
    public int getQuantityOfFruit() {
        return Integer.parseInt(parsedData[QUANTITY_OF_FRUITS]);
    }

    @Override
    public void parseString(String dataToParse) {
        parsedData = dataToParse.split(CSV_SEPARATOR);
    }

    @Override
    public void clear() {
        parsedData = new String[0];
    }
}
