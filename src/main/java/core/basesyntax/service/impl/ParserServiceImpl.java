package core.basesyntax.service.impl;

import core.basesyntax.service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_SYMBOL = ",";
    private String[] arrayParameters;

    @Override
    public String getType(String line) {
        arrayParameters = line.split(SPLIT_SYMBOL);
        return arrayParameters[TYPE_INDEX];
    }

    @Override
    public String getFruit(String line) {
        arrayParameters = line.split(SPLIT_SYMBOL);
        return arrayParameters[FRUIT_INDEX];
    }

    @Override
    public int getQuantity(String line) {
        arrayParameters = line.split(SPLIT_SYMBOL);
        return Integer.parseInt(arrayParameters[QUANTITY_INDEX]);
    }
}
