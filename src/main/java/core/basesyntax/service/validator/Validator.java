package core.basesyntax.service.validator;

import core.basesyntax.model.FruitTransaction;

public class Validator {
    private static final int QUANTITY_MARKER = 0;
    private static final String FILE_FORMAT = "csv";
    private static final int SEPARATOR_INDEX = 1;

    public boolean validateFruitTransaction(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new IllegalArgumentException("Fruit transaction can`t be null");
        }
        if (fruitTransaction.getQuantity() < QUANTITY_MARKER) {
            throw new IllegalArgumentException("Balance can`t be negative");
        }
        return true;
    }

    public boolean checkFileName(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Wrong file name" + fileName);
        }
        if (!fileName.split("\\.")[SEPARATOR_INDEX].equals(FILE_FORMAT)) {
            throw new IllegalArgumentException("Wrong file format. Expected CSV file");
        }
        return true;
    }

    public boolean checkTransaction(String operation, String fruit, String quantity) {
        if (operation.equals("")) {
            throw new IllegalArgumentException("Activity type is empty.");
        }
        if (fruit.equals("")) {
            throw new IllegalArgumentException("Fruit name is empty.");
        }
        if (quantity.equals("")) {
            throw new IllegalArgumentException("Quantity value is empty.");
        }
        return true;
    }
}
