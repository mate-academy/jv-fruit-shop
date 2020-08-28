package core.basesyntax.service;

import core.basesyntax.Transaction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConverterCsvToTransaction {
    public Transaction convert(List<String> data) {
        Transaction transaction = new Transaction();
        transaction.setOperation(data.get(0));
        transaction.setFruitName(data.get(1));
        transaction.setQuantity(Integer.parseInt(data.get(2)));
        transaction.setDate(LocalDate.parse(data.get(3), DateTimeFormatter.ISO_LOCAL_DATE));
        return transaction;
    }
}
