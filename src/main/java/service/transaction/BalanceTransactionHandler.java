package service.transaction;

public class BalanceTransactionHandler implements TransactionHandler {

    @Override
    public void apply(String fruit, Integer amount) {
        storageDao.add(fruit, amount);
    }
}
