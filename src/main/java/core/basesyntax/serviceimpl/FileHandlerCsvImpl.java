package core.basesyntax.serviceimpl;

import core.basesyntax.exception.InvalidDataInFile;
import core.basesyntax.service.FileHandlerCsv;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerCsvImpl implements FileHandlerCsv {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> info) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : info) {
            String[] operations = line.split(System.lineSeparator());
            for (String operation : operations) {
                String[] data = operation.split(COMMA);
                FruitTransaction fruitBalance = new FruitTransaction();
                fruitBalance.setOperation(getOperation(data[OPERATION_INDEX]));
                if (validatorFruits(data[FRUIT_INDEX])) {
                    throw new InvalidDataInFile("Fruit is not exist");
                }
                fruitBalance.setFruit(data[FRUIT_INDEX]);
                try {
                    if (validatorQuantity(data[QUANTITY_INDEX])) {
                        throw new InvalidDataInFile("Quantity is not valid: " + data[QUANTITY_INDEX]);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new InvalidDataInFile("Quantity is not exist");
                }
                fruitBalance.setQuantity(Integer.parseInt(data[QUANTITY_INDEX]));
                fruitTransactions.add(fruitBalance);
            }
        }
        return fruitTransactions;
    }

    private FruitTransaction.Operation getOperation(String operation) {
        if (operation.equals(FruitTransaction.Operation.PURCHASE.getCode())) {
            return FruitTransaction.Operation.PURCHASE;
        } else if (operation.equals(FruitTransaction.Operation.BALANCE.getCode())) {
            return FruitTransaction.Operation.BALANCE;
        } else if (operation.equals(FruitTransaction.Operation.RETURN.getCode())) {
            return FruitTransaction.Operation.RETURN;
        } else if (operation.equals(FruitTransaction.Operation.SUPPLY.getCode())) {
            return FruitTransaction.Operation.SUPPLY;
        }
        throw new InvalidDataInFile("Operation is not exist: " + operation);
    }

    private boolean validatorFruits(String info) {
        return info == null || info.isEmpty();
    }

    private boolean validatorQuantity(String info) {
        try {
            return info == null || Integer.parseInt(info) < 0;
        } catch (NumberFormatException e) {
            throw new InvalidDataInFile("Input quantity is not valid: " + info);
        }
    }
}
