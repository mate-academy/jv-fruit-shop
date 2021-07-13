package core.basesyntax.model;

public class RecordsValidatorImpl implements RecordsValidator {
    @Override
    public Record validate(String operationType, String fruitName, String quantity) {
        int fruitQuantity;
        try {
            fruitQuantity = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Data input file contains illegal "
                    + "quantity record: " + quantity);
        }

        if (fruitQuantity < 0 || quantity.equals("")) {
            throw new IllegalArgumentException("Data input file contains illegal "
                    + "quantity record: " + quantity);
        }

        if (fruitName == null || fruitName.equals("")) {
            throw new IllegalArgumentException("Data input file contains illegal "
                    + "fruit name record: " + fruitName);
        }

        if (operationType == null) {
            throw new IllegalArgumentException("Operation type cannot be NULL");
        }

        switch (operationType) {
            case "b":
                return new Record(Record.OperationType.BALANCE, fruitName, fruitQuantity);
            case "s":
                return new Record(Record.OperationType.SUPPLY, fruitName, fruitQuantity);
            case "p":
                return new Record(Record.OperationType.PURCHASE, fruitName, fruitQuantity);
            case "r":
                return new Record(Record.OperationType.RETURN, fruitName, fruitQuantity);
            default:
                throw new IllegalArgumentException("Data input file contains illegal "
                        + "operation record: " + operationType);
        }
    }
}
