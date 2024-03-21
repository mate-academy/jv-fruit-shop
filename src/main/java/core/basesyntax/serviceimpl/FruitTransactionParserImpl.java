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
    private final List<FruitTransaction> fruitTransactions = new ArrayList<>();

    @Override
    public List<FruitTransaction> parse(List<String> info) {
        for (String line : info) {
            String[] operations = line.split(System.lineSeparator());
            for (String operation : operations) {
                String[] data = operation.split(SEPARATOR);
                FruitTransaction fruitBalance = new FruitTransaction();
                fruitBalance.setOperation(getOperation(data[OPERATION_INDEX]));
                if (validatorFruits(data[FRUIT_INDEX])) {
                    throw new InvalidDataException("Fruit is not exist");
                }
                fruitBalance.setFruit(data[FRUIT_INDEX]);
                try {
                    if (validatorQuantity(data[QUANTITY_INDEX])) {
                        throw new InvalidDataException("Quantity is not valid: "
                                + data[QUANTITY_INDEX]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new InvalidDataException("Quantity is not exist");
                }
                fruitBalance.setQuantity(Integer.parseInt(data[QUANTITY_INDEX]));
                fruitTransactions.add(fruitBalance);
            }
        }
        return fruitTransactions;
    }

    private String[] separateOperations(List<String> info) {
        for (String line : info) {
            String[] operations = line.split(System.lineSeparator());
            for (String operation : operations) {
                return operation.split(SEPARATOR);
            }
        }
        throw new InvalidDataException("Data is not exist");
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
        return info == null;
    }

    private boolean validatorQuantity(String info) {
        try {
            return info == null || Integer.parseInt(info) < 0;
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Input quantity is not valid: " + info);
        }
    }
}
