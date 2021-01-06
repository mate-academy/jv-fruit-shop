package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class TransactionDtoFactory {
    private static final String SEPARATOR = ",";
    private static final String BUY_SIGNATURE = "b";
    private static final String SUPPLY_SIGNATURE = "s";
    private static final String PURCHASE_SIGNATURE = "p";
    private static final String RETURN_SIGNATURE = "r";
    private static final List<String> signatures
            = new ArrayList<>(List.of(BUY_SIGNATURE,
            SUPPLY_SIGNATURE, PURCHASE_SIGNATURE, RETURN_SIGNATURE));

    public static TransactionDto build(String line) {
        String[] array = line.split(SEPARATOR);
        if (signatures.contains(array[0])
                && Integer.parseInt(array[2]) < 0) {
            throw new RuntimeException("This type of operation cannot "
                    + "be used with the negative values.");
        }
        if (array.length != 3) {
            throw new RuntimeException("Incorrect format");
        }
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setOperation(Operation.fromString(array[0]));
        transactionDto.setFruit(new Fruit(array[1]));
        transactionDto.setQuantity(Integer.parseInt(array[2]));
        return transactionDto;
    }
}
