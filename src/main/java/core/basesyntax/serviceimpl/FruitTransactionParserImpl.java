package core.basesyntax.serviceimpl;

import core.basesyntax.exception.InvalidDataException;
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
            parseLine(line, fruitTransactions);
        }
        return fruitTransactions;
    }

    private void parseLine(String line, List<FruitTransaction> fruitTransactions) {
        String[] operations = line.split(System.lineSeparator());
        for (String operation : operations) {
            String[] data = operation.split(SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(getOperation(data[OPERATION_INDEX]));
            validateAndSetData(data, fruitTransaction);
            fruitTransactions.add(fruitTransaction);
        }
    }

    private void validateAndSetData(String[] data, FruitTransaction fruitTransaction) {
        String fruit = data[FRUIT_INDEX];
        if (validatorFruits(fruit)) {
            throw new InvalidDataException("Fruit does not exist: " + fruit);
        }
        fruitTransaction.setFruit(fruit);
        int quantity;
        try {
            quantity = Integer.parseInt(data[QUANTITY_INDEX]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new InvalidDataException("Fruit does not exist: " + fruit);
        }
        if (validatorQuantity(quantity)) {
            throw new InvalidDataException("Fruit does not exist: " + fruit);
        }
        fruitTransaction.setQuantity(quantity);
    }

    private FruitTransaction.Operation getOperation(String operation) {
        for (FruitTransaction.Operation operationEnum : FruitTransaction.Operation.values()) {
            if (operation.equals(operationEnum.getCode())) {
                return operationEnum;
            }
        }
        throw new InvalidDataException("Operation is not exist" + operation);
    }

    private boolean validatorFruits(String info) {
        return info == null || info.isEmpty();
    }

    private boolean validatorQuantity(int info) {
        try {
            return info < 0;
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Input quantity is not valid: " + info);
        }
    }
}
