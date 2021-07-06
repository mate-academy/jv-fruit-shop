package service;

import dto.Transaction;

public class ParserImpl implements Parser {
    private static final int TYPE_OPERATION = 0;
    private static final int NAME_FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final int COUNT_DATA = 3;
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String SYMBOL_FOR_SPLIT = ",";

    @Override
    public Transaction parseLine(String line) {
        int quantity = 0;
        String nameFruit = "";
        String typeOperation = "";
        String[] dataArray = line.split(SYMBOL_FOR_SPLIT);
        if (dataArray.length != COUNT_DATA) {
            throw new RuntimeException("Uncorrected this line - " + line);
        }
        if (validateOperation(dataArray[TYPE_OPERATION])
                && validate(dataArray[NAME_FRUIT])
                && validateQuantity(dataArray[QUANTITY])) {
            typeOperation = dataArray[TYPE_OPERATION];
            nameFruit = dataArray[NAME_FRUIT];
            quantity = Integer.parseInt(dataArray[QUANTITY]);
        }
        return new Transaction(typeOperation, nameFruit, quantity);
    }

    private boolean validateOperation(String operation) {
        if (operation.equals(BALANCE) || operation.equals(SUPPLY)
                || operation.equals(PURCHASE) || operation.equals(RETURN)) {
            return true;
        }
        throw new RuntimeException("Uncorrected this type operation - " + operation);
    }

    private boolean validate(String fruitName) {
        char[] arrayCharsFruit = fruitName.toCharArray();
        for (char charChecked : arrayCharsFruit) {
            if (!Character.isLetter(charChecked)) {
                throw new RuntimeException("Uncorrected this name fruit - " + fruitName);
            }
        }
        return true;
    }

    private boolean validateQuantity(String quantity) {
        try {
            if (Integer.parseInt(quantity) > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Uncorrected this quantity - " + quantity);
        }
        throw new RuntimeException("Uncorrected this quantity - " + quantity);
    }
}
