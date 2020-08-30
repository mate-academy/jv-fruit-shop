package core.basesyntax.operation;

import core.basesyntax.fruitservice.Transaction;
import java.util.Map;

public class SupplyOperation implements Operation {
    private TransactionValidator transactionValidator = new TransactionValidator();

    @Override
    public void operation(Map<String, Integer> fruitDao, Transaction transaction) {
        if (transactionValidator.checkDate(transaction)) {
            return;
        }
        fruitDao.merge(transaction.getProduct(), transaction.getQuantity(), Integer::sum);
    }
}
