package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionCreationService;
import java.util.List;

public class FruitTransactionCreationServiceImpl implements FruitTransactionCreationService {
    private static FruitTransaction.Operation operation;
    private static String fruitType = "";
    private static int fruitQuantity = 0;
    private final FruitDao dao;
    private static final int firstPosition = 0;
    private static final int secondPosition = 1;
    private static final int thirdPosition = 2;

    public FruitTransactionCreationServiceImpl(FruitDao dao) {
        this.dao = dao;
    }

    @Override
    public void createTransactions(List<String[]> data) {
        FruitTransaction transaction;
        for (String[] parameters : data) {
            transaction = new FruitTransaction();
            operation = FruitTransaction.Operation.getFromString(parameters[firstPosition]);
            fruitType = parameters[secondPosition];
            fruitQuantity = Integer.parseInt(parameters[thirdPosition]);
            transaction.setFruit(fruitType);
            transaction.setOperation(operation);
            transaction.setQuantity(fruitQuantity);
            dao.add(transaction);
        }
    }
}
