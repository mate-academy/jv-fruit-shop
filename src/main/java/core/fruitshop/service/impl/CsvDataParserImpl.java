package core.fruitshop.service.impl;

import core.fruitshop.OperationType;
import core.fruitshop.model.FruitTransaction;
import core.fruitshop.service.DataParser;

public class CsvDataParserImpl implements DataParser {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int PRODUCT_AMOUNT_INDEX = 2;
    private final String columnSeparator;
    private String[] stringToParse;

    public CsvDataParserImpl(String columnSeparator) {
        this.columnSeparator = columnSeparator;
    }

    public FruitTransaction parse(String stringToParse) {
        this.stringToParse = stringToParse.split(columnSeparator);
        return new FruitTransaction(getOperationType(),
                getProductName(), getProductAmount());
    }

    private OperationType getOperationType() {
        String type = stringToParse[OPERATION_TYPE_INDEX];
        return OperationType.fromString(type);
    }

    private String getProductName() {
        return stringToParse[PRODUCT_NAME_INDEX];
    }

    private int getProductAmount() {
        return Integer.parseInt(stringToParse[PRODUCT_AMOUNT_INDEX]);
    }
}
