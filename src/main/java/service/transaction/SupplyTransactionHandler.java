package service.transaction;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public void apply(String fruit, Integer amount) {
        Integer newAmount = storageDao.getAmount(fruit) + amount;
        storageDao.update(fruit, newAmount);
    }
}
