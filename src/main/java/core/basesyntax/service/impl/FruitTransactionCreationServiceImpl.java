package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionCreationService;
import java.util.List;

public class FruitTransactionCreationServiceImpl implements FruitTransactionCreationService {
    private static final int FIRST_POSITION = 0;
    private static final int SECOND_POSITION = 1;
    private static final int THIRD_POSITION = 2;
    private final FruitDao dao;

    public FruitTransactionCreationServiceImpl(FruitDao dao) {
        this.dao = dao;
    }

    @Override
    public void createTransactions(List<String[]> data) {
        FruitTransaction transaction;
        for (String[] parameters : data) {
            transaction = new FruitTransaction();
            FruitTransaction.Operation operation
                    = FruitTransaction.Operation.getFromString(parameters[FIRST_POSITION]);
            String fruitType = parameters[SECOND_POSITION];
            int fruitQuantity = Integer.parseInt(parameters[THIRD_POSITION]);
            transaction.setFruit(fruitType);
            transaction.setOperation(operation);
            transaction.setQuantity(fruitQuantity);
            dao.add(transaction);
        }
    }
}
