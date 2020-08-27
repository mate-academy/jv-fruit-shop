package core.basesyntax.operation;

import core.basesyntax.fruitservice.Transaction;
import java.util.Map;

public class Return implements Operation {
    @Override
    public void operation(Map<String,Integer> fruitDao, Transaction transaction) {
        if (ValidationData.checkDate(transaction)) {
            return;
        }
        if (fruitDao.containsKey(transaction.getProduct())) {
            fruitDao.compute(transaction.getProduct(), (a, b) -> b + transaction.getQuantity());
        }
    }
}
