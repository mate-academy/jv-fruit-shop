package core.basesyntax.operation;

import core.basesyntax.fruitservice.Transaction;
import java.time.LocalDate;

public class ValidationData {
    public static boolean checkDate(Transaction transaction) {
        if (transaction.getDate().compareTo(LocalDate.now()) < 0) {
            return true;
        }
        return false;
    }
}
