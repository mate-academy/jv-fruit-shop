package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransactionImpl;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    public static final int PARTS_LENGTH = 3;
    public static final int OPERATION_PART = 0;
    public static final int FRUIT_PART = 1;
    public static final int QUANTITY_PART = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        for (String line : inputReport) {
            if (line == null || line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");

            if (parts.length != PARTS_LENGTH) {
                System.out.println("Запис не повний: " + line);
                continue;
            }

            try {
                FruitTransaction fruitTransaction = new FruitTransactionImpl();
                fruitTransaction.setOperation(getOperationByCode(parts[OPERATION_PART].trim()));
                fruitTransaction.setFruit(parts[FRUIT_PART].trim());
                fruitTransaction.setQuantity(Integer.parseInt(parts[QUANTITY_PART].trim()));
                fruitTransactionList.add(fruitTransaction);
            } catch (NumberFormatException e) {
                System.out.println("Некоректне число в записі: " + line);
            }
        }
        return fruitTransactionList;
    }

    @Override
    public FruitTransaction.Operation getOperationByCode(String code) {
        for (FruitTransaction.Operation op : FruitTransaction.Operation.values()) {
            if (op.getCode().equals(code)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Невідомий код операції: " + code);
    }
}
