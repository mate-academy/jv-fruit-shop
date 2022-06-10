package service.impl;

import dao.AccountDaoImplementation;
import model.FruitTransaction;
import service.OperationService;

public class SetBalanceOperationImplementation implements OperationService {
    private final AccountDaoImplementation accountDaoImplementation;

    SetBalanceOperationImplementation(AccountDaoImplementation accountDaoImplementation) {
        this.accountDaoImplementation = accountDaoImplementation;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        accountDaoImplementation.set(transaction.getFruit(), transaction.getQuantity());
    }
}
