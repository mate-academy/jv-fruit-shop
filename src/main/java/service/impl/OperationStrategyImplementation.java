package service.impl;

import dao.AccountDaoImplementation;
import model.FruitTransaction;
import service.OperationService;
import service.OperationStrategy;

public class OperationStrategyImplementation implements OperationStrategy {
    private final AccountDaoImplementation accountDaoImplementation;

    public OperationStrategyImplementation(AccountDaoImplementation accountDaoImplementation) {
        this.accountDaoImplementation = accountDaoImplementation;
    }

    @Override
    public OperationService getOperationServiceByTransaction(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case SUPPLY:
            case RETURN:
                return new AddOperationImplementation(accountDaoImplementation);
            case PURCHASE:
                return new SubtractOperationImplementation(accountDaoImplementation);
            default:
                return new SetBalanceOperationImplementation(accountDaoImplementation);
        }
    }
}
