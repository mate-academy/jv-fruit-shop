package core.fruitshop.services.impl;

import core.fruitshop.OperationType;
import core.fruitshop.model.FruitTransaction;
import core.fruitshop.services.DataExtractor;

public class CsvDataExtractorImpl implements DataExtractor {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int PRODUCT_AMOUNT_INDEX = 2;
    private static final String COLUMN_SEPARATOR = ",";
    private String[] stringToParse;

    public FruitTransaction parse(String stringToParse) {
        this.stringToParse = stringToParse.split(COLUMN_SEPARATOR);
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
