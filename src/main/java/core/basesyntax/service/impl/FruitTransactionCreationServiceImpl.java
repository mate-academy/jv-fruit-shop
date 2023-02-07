package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionCreationService;
import java.util.List;

public class FruitTransactionCreationServiceImpl implements FruitTransactionCreationService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
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
                    = FruitTransaction.Operation.getFromString(parameters[OPERATION_INDEX]);
            String fruitType = parameters[FRUIT_TYPE_INDEX];
            int fruitQuantity = Integer.parseInt(parameters[FRUIT_QUANTITY_INDEX]);
            transaction.setFruit(fruitType);
            transaction.setOperation(operation);
            transaction.setQuantity(fruitQuantity);
            dao.add(transaction);
        }
    }
}
