package core.basesyntax.operation;

import core.basesyntax.fruitservice.Transaction;
import java.time.LocalDate;

public class TransactionValidator {
    public boolean checkDate(Transaction transaction) {
        return transaction.getDate().compareTo(LocalDate.now()) < 0;
    }
}
