package core.basesyntax.service.transactionOperations;

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
        FruitTransaction.Operation operation;
        String fruit;
        int amount;
        for (String[] parameters : data) {
            if (parameters[0].equals(FruitTransaction.Operation.BALANCE.getOperation())) {
                operation = FruitTransaction.Operation.BALANCE;
            } else if (parameters[0].equals(FruitTransaction.Operation.PURCHASE.getOperation())) {
                operation = FruitTransaction.Operation.PURCHASE;
            } else if (parameters[0].equals(FruitTransaction.Operation.RETURN.getOperation())) {
                operation = FruitTransaction.Operation.RETURN;
            } else {
                operation = FruitTransaction.Operation.SUPPLY;
            }
            fruit = parameters[1];
            amount = Integer.parseInt(parameters[2]);
            transaction = new FruitTransaction();
            transaction.setFruit(fruit);
            transaction.setOperation(operation);
            transaction.setQuantity(amount);
            dao.add(transaction);
        }

    }
}
