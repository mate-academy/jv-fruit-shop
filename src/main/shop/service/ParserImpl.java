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
    private int quantity;
    private String nameFruit;
    private String typeOperation;

    @Override
    public Transaction parseLine(String line) {
        String[] arrayParse = line.split(",");
        if (arrayParse.length != COUNT_DATA) {
            throw new RuntimeException("Uncorrected this line - " + line);
        }
        if (typeOperationValidator(arrayParse[TYPE_OPERATION])) {
            typeOperation = arrayParse[TYPE_OPERATION];
        }
        if (nameFruitValidator(arrayParse[NAME_FRUIT])) {
            nameFruit = arrayParse[NAME_FRUIT];
        }
        if (quantityValidator(arrayParse[QUANTITY])) {
            quantity = Integer.parseInt(arrayParse[QUANTITY]);
        }
        return new Transaction(typeOperation, nameFruit, quantity);
    }

    private boolean typeOperationValidator(String typeOperation) {
        if (typeOperation.equals(BALANCE) || typeOperation.equals(SUPPLY)
                || typeOperation.equals(PURCHASE) || typeOperation.equals(RETURN)) {
            return true;
        }
        throw new RuntimeException("Uncorrected this type operation - " + typeOperation);
    }

    private boolean nameFruitValidator(String nameFruit) {
        char[] arrayCharsFruit = nameFruit.toCharArray();
        for (int i = 0; i < arrayCharsFruit.length; i++) {
            if (! Character.isLetter(arrayCharsFruit[i])) {
                throw new RuntimeException("Uncorrected this name fruit - " + nameFruit);
            }
        }
        return true;
    }

    private boolean quantityValidator(String quantity) {
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
