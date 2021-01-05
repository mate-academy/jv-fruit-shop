package core.basesyntax.service.impl;

import core.basesyntax.model.Fruits;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;

public class TransactionDtoFactory {
    public static final String BUY_SIGNATURE = "b";
    public static final String SUPPLY_SIGNATURE = "s";
    public static final String PURCHASE_SIGNATURE = "p";
    public static final String RETURN_SIGNATURE = "r";
    public static final String SEPARATOR = ",";

    public static TransactionDto build(String line) {
        String[] array = line.split(SEPARATOR);
        if (array[0].equals(BUY_SIGNATURE)
                && Integer.parseInt(array[2]) < 0) {
            throw new RuntimeException("Balance can't be lower than 0");
        }
        if (array[0].equals(SUPPLY_SIGNATURE)
                && Integer.parseInt(array[2]) < 0) {
            throw new RuntimeException("Supply can't be lower than 0");
        }
        if (array[0].equals(PURCHASE_SIGNATURE)
                && Integer.parseInt(array[2]) < 0) {
            throw new RuntimeException("Purchase should be positive, without '-'");
        }
        if (array[0].equals(RETURN_SIGNATURE)
                && Integer.parseInt(array[2]) < 0) {
            throw new RuntimeException("Return can't be lower than 0");
        }
        if (array.length != 3) {
            throw new RuntimeException("Incorrect format");
        }
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setOperation(Operation.fromString(array[0]));
        transactionDto.setFruit(new Fruits(array[1]));
        transactionDto.setQuantity(Integer.parseInt(array[2]));
        return transactionDto;
    }
}
