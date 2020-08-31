package core.basesyntax.service;

import core.basesyntax.Transaction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConverterCsvToTransactions {
    public List<Transaction> convert(List<List<String>> fileStrings) {
        List<Transaction> transactions = new ArrayList<>();
        for (List<String> data : fileStrings) {
            Transaction transaction = new Transaction(data.get(0), data.get(1),
                    Integer.parseInt(data.get(2)),
                    LocalDate.parse(data.get(3), DateTimeFormatter.ISO_LOCAL_DATE));
            transactions.add(transaction);
        }
        return transactions;
    }
}
