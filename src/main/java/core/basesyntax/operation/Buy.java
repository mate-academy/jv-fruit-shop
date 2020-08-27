package core.basesyntax.operation;

import core.basesyntax.fruitservice.Transaction;
import java.time.LocalDate;
import java.util.Map;

public class Buy implements Operation {
    @Override
    public void operation(Map<String,Integer> fruitDao, Transaction transaction) {
        if (transaction.getDate().compareTo(LocalDate.now()) < 0) {
            return;
        }
        if (fruitDao.containsKey(transaction.getProduct())) {
            fruitDao.compute(transaction.getProduct(), (a, b) -> b - transaction.getQuantity());
        }
    }
}
