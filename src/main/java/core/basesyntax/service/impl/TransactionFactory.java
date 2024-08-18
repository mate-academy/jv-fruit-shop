package core.basesyntax.service.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import java.util.HashMap;
import java.util.Map;

public class TransactionFactory {

    private static final Map<String, Operation> operationMap = new HashMap<>();

    static {
        for (Operation op : Operation.values()) {
            operationMap.put(op.getCode(), op);
        }
    }

    public FruitTransaction createTransaction(String[] parts) {
        Operation operation = parseOperation(parts[0]);
        String fruit = parts[1];
        int quantity = parseQuantity(parts[2]);

        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(operation);
        transaction.setFruit(fruit);
        transaction.setQuantity(quantity);
        return transaction;
    }

    private Operation parseOperation(String code) {
        Operation operation = operationMap.get(code);
        if (operation == null) {
            throw new IllegalArgumentException("Неизвестный код операции: " + code);
        }
        return operation;
    }

    private int parseQuantity(String quantityStr) {
        try {
            return Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат количества: " + quantityStr);
        }
    }
}
