package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

import java.util.List;

public class FruitTransactionCreationServiceImpl implements FruitTransactionCreationService {
    private FruitDao dao;

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
            String operationValue = parameters[0];
            String fruitType = parameters[1];
            int fruitQuantity = Integer.parseInt(parameters[2]);
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
