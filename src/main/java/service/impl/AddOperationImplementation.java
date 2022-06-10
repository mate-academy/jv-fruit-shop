package service.impl;

import dao.AccountDaoImplementation;
import model.FruitTransaction;
import service.OperationService;

public class AddOperationImplementation implements OperationService {
    private final AccountDaoImplementation accountDaoImplementation;

    AddOperationImplementation(AccountDaoImplementation accountDaoImplementation) {
        this.accountDaoImplementation = accountDaoImplementation;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        accountDaoImplementation.add(transaction.getFruit(), transaction.getQuantity());
    }
}
