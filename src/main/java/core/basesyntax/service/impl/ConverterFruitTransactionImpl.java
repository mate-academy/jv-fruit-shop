package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterFruitTransaction;
import java.util.List;

public class ConverterFruitTransactionImpl implements ConverterFruitTransaction {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> converterFruitTransaction(List<String> readFruitTransaction) {
        readFruitTransaction.remove(OPERATION_INDEX);

        return readFruitTransaction.stream()
                .map(this::getTransaction)
                .toList();
    }

    private FruitTransaction getTransaction(String fromFile) {
        String[] fruitTransactionArray = fromFile.split(SEPARATOR);
        if (fruitTransactionArray.length != 3) {
            throw new IllegalArgumentException(
                    "Invalid line structure: Expected 3 values but found "
                            + fruitTransactionArray.length + ". Line content: "
                            + fromFile);
        }

        try {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .fromCode(fruitTransactionArray[OPERATION_INDEX]));
            fruitTransaction.setFruit(fruitTransactionArray[FRUIT_INDEX]);

            int quantity = Integer.parseInt(fruitTransactionArray[QUANTITY_INDEX]);
            if (quantity < 0) {
                throw new IllegalArgumentException(
                        "Quantity cannot be negative. Line content: " + fromFile);
            }
            fruitTransaction.setQuantity(quantity);

            return fruitTransaction;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Invalid number format for quantity. Line content: " + fromFile, e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid quantity. Line content: " + fromFile, e);
        }
    }
}
