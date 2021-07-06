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
        String[] dataArray = line.split(SYMBOL_FOR_SPLIT);
        if (dataArray.length != COUNT_DATA) {
            throw new RuntimeException("Uncorrected this line - " + line);
        }
        validateOperation(dataArray[TYPE_OPERATION]);
        validateName(dataArray[NAME_FRUIT]);
        String typeOperation = dataArray[TYPE_OPERATION];
        String nameFruit = dataArray[NAME_FRUIT];
        int quantity = Integer.parseInt(dataArray[QUANTITY]);
        if (quantity < 0) {
            throw new RuntimeException("Numbers is uncorrected " + quantity);
        }
        return new Transaction(typeOperation, nameFruit, quantity);
    }

    private void validateOperation(String operation) {
        if (!(operation.equals(BALANCE) || operation.equals(SUPPLY)
                || operation.equals(PURCHASE) || operation.equals(RETURN))) {
            throw new RuntimeException("Uncorrected this type operation - " + operation);
        }
    }

    private void validateName(String fruitName) {
        char[] arrayCharsFruit = fruitName.toCharArray();
        for (char charChecked : arrayCharsFruit) {
            if (!Character.isLetter(charChecked)) {
                throw new RuntimeException("Uncorrected this name fruit - " + fruitName);
            }
        }
    }
}
