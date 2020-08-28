package core.basesyntax.daily;

import java.io.IOException;
import java.time.LocalDate;

public class Mapper {

    public Transaction convert(String[] line) throws IOException {
        Transaction transaction = new Transaction();
        try {
            transaction.setOperation(line[0].trim().charAt(0));
            transaction.setFruitName(line[1]);
            transaction.setQuantity(Integer.parseInt(line[2]));
            transaction.setTransactionDate(LocalDate.parse(line[3]));
            return transaction;
        } catch (RuntimeException e) {
            throw new RuntimeException("Incorrect data in file");
        }
    }
}
