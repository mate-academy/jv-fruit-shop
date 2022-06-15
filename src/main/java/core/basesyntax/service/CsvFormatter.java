package core.basesyntax.service;

import core.basesyntax.db.TransactionList;
import core.basesyntax.model.Transaction;

public class CsvFormatter {

    public static void csvToStringArrayList(String csvString) {
        for (String csvLine: csvString.split("\n")) {
            if (csvLine.equals("null")) {
                continue;
            }
            Transaction transaction = new Transaction(csvLine);
            TransactionList.getTransactionList().add(transaction);
        }
    }
}
