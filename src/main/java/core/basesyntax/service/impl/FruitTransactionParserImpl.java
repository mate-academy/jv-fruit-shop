package core.basesyntax.service.impl;

import static core.basesyntax.model.FruitTransaction.Operation.getOperation;

import core.basesyntax.exception.InvalidDataException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> info) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : info) {
            fruitTransactions.add(parseLine(line));
        }
        return fruitTransactions;
    }

    private FruitTransaction parseLine(String line) {
        String[] data = line.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(getOperation(data[OPERATION_INDEX]));
        validateAndSetData(data, fruitTransaction);
        return fruitTransaction;
    }

    private void validateAndSetData(String[] data, FruitTransaction fruitTransaction) {
        String fruit = data[FRUIT_INDEX];
        if (isFruitsNoTNull(fruit)) {
            throw new InvalidDataException("Fruit does not exist: " + fruit);
        }
        fruitTransaction.setFruit(fruit);
        int quantity;
        try {
            quantity = Integer.parseInt(data[QUANTITY_INDEX]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new InvalidDataException("Fruit does not exist: " + fruit);
        }
        if (isQuantityNotNull(quantity)) {
            throw new InvalidDataException("Fruit does not exist: " + fruit);
        }
        fruitTransaction.setQuantity(quantity);
    }

    private boolean isFruitsNoTNull(String info) {
        return info == null || info.isEmpty();
    }

    private boolean isQuantityNotNull(int info) {
        try {
            return info < 0;
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Input quantity is not valid: " + info);
        }
    }
}
