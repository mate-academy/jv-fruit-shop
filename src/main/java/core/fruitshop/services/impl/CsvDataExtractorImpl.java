package core.fruitshop.services.impl;

import core.fruitshop.OperationType;
import core.fruitshop.exceptions.IncorrectOperationTypeException;
import core.fruitshop.model.FruitTransaction;
import core.fruitshop.services.DataExtractor;

public class CsvDataExtractorImpl implements DataExtractor {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int PRODUCT_AMOUNT_INDEX = 2;
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String RETURN = "r";
    private static final String PURCHASE = "p";
    private static final String INCORRECT_TYPE_EXCEPTION = "Incorrect operation type. "
            + "Expected: " + BALANCE + ","
            + SUPPLY + "," + RETURN + "or" + PURCHASE + ", but was: ";
    private static final String COLUMN_SEPARATOR = ",";
    private String[] stringToParse;

    public FruitTransaction parse(String stringToParse) {
        this.stringToParse = stringToParse.split(COLUMN_SEPARATOR);
        return new FruitTransaction(getOperationType(),
                getProductName(), getProductAmount());
    }

    private OperationType getOperationType() {
        String type = stringToParse[OPERATION_TYPE_INDEX];
        switch (type) {
            case BALANCE:
                return OperationType.BALANCE;
            case SUPPLY:
                return OperationType.SUPPLY;
            case RETURN:
                return OperationType.RETURN;
            case PURCHASE:
                return OperationType.PURCHASE;
            default:
                throw new IncorrectOperationTypeException(INCORRECT_TYPE_EXCEPTION + type);
        }
    }

    private String getProductName() {
        return stringToParse[PRODUCT_NAME_INDEX];
    }

    private int getProductAmount() {
        return Integer.parseInt(stringToParse[PRODUCT_AMOUNT_INDEX]);
    }
}
