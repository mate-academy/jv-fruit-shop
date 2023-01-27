package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionCreationService;
import java.util.List;

public class FruitTransactionCreationServiceImpl implements FruitTransactionCreationService {
    private static String operationValue = "b";
    private static String fruitType = "";
    private static int fruitQuantity = 0;
    private final FruitDao dao;

    public FruitTransactionCreationServiceImpl(FruitDao dao) {
        this.dao = dao;
    }

    @Override
    public void createTransactions(List<String[]> data) {
        FruitTransaction transaction;
        FruitTransaction.Operation operation = null;
        String fruit;
        int amount;
        for (String[] parameters : data) {
            transaction = new FruitTransaction();
            operationValue = parameters[0];
            fruitType = parameters[1];
            fruitQuantity = Integer.parseInt(parameters[2]);
            for (FruitTransaction.Operation op : FruitTransaction.Operation.values()) {
                if (op.toString().equalsIgnoreCase(operationValue)) {
                    operation = op;
                }
            }
            fruit = fruitType;
            amount = fruitQuantity;
            transaction.setFruit(fruit);
            transaction.setOperation(operation);
            transaction.setQuantity(amount);
            dao.add(transaction);
        }

    }
}
