package core.basesyntax.service.impl;

import core.basesyntax.model.Fruits;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;

public class TransactionDtoFactory {
    public static TransactionDto build(String line) {
        TransactionDto transactionDto = new TransactionDto();
        String[] array = line.split(",");
        if (array[0].equals("b")
                && Integer.parseInt(array[2]) < 0) {
            throw new RuntimeException("Balance can't be lower than 0");
        }
        if (array[0].equals("s")
                && Integer.parseInt(array[2]) < 0) {
            throw new RuntimeException("Supply can't be lower than 0");
        }
        if (array[0].equals("p")
                && Integer.parseInt(array[2]) < 0) {
            throw new RuntimeException("Purchase should be positive, without '-'");
        }
        if (array[0].equals("r")
                && Integer.parseInt(array[2]) < 0) {
            throw new RuntimeException("Return can't be lower than 0");
        }
        transactionDto.setOperation(Operation.fromString(array[0]));
        transactionDto.setFruit(new Fruits(array[1]));
        transactionDto.setQuantity(Integer.parseInt(array[2]));
        return transactionDto;
    }
}
