package service.impl;

import dao.AccountDaoImplementation;
import model.FruitTransaction;
import service.OperationService;

public class SubtractOperationImplementation implements OperationService {
    private final AccountDaoImplementation accountDaoImplementation;

    SubtractOperationImplementation(AccountDaoImplementation accountDaoImplementation) {
        this.accountDaoImplementation = accountDaoImplementation;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        accountDaoImplementation.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}
