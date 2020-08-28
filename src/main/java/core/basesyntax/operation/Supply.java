package core.basesyntax.operation;

import core.basesyntax.fruitservice.Transaction;
import java.util.Map;

public class Supply implements Operation {
    @Override
    public void operation(Map<String, Integer> fruitDao, Transaction transaction) {
        if (ValidationData.checkDate(transaction)) {
            return;
        }
        fruitDao.merge(transaction.getProduct(), transaction.getQuantity(), Integer::sum);
    }
}
