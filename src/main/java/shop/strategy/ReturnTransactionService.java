package shop.strategy;

import shop.model.FruitTransaction;

public class ReturnTransactionService implements TransactionService {
    @Override
    public void process(FruitTransaction transaction) {
        int currentQuantity = dao.getQuantity(transaction.getFruit());
        dao.setQuantity(transaction.getFruit(), currentQuantity + transaction.getQuantity());
    }
}
