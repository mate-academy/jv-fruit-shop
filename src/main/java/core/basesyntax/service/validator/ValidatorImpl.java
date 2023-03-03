package core.basesyntax.service.validator;

import core.basesyntax.model.FruitTransaction;

public class ValidatorImpl implements Validator {
    private static final int QUANTITY_MARKER = 0;
    private static final String FILE_FORMAT = "csv";
    private static final int SEPARATOR_INDEX = 1;

    @Override
    public boolean validateFruitTransaction(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("Fruit transaction can`t be null");
        }
        if (fruitTransaction.getQuantity() < QUANTITY_MARKER) {
            throw new RuntimeException("Balance can`t be negative");
        }
        return true;
    }

    @Override
    public boolean checkFileName(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new RuntimeException("Wrong file name" + fileName);
        }
        if (!fileName.split("\\.")[SEPARATOR_INDEX].equals(FILE_FORMAT)) {
            throw new RuntimeException("Wrong file format. Expected CSV file");
        }
        return true;
    }

    @Override
    public boolean checkTransaction(String operation, String fruit, String quantity) {
        if (operation.equals("")) {
            throw new RuntimeException("Activity type is empty.");
        }
        if (fruit.equals("")) {
            throw new RuntimeException("Fruit name is empty.");
        }
        if (quantity.equals("")) {
            throw new RuntimeException("Quantity value is empty.");
        }
        return true;
    }
}
