package core.basesyntax.fileservice;

import core.basesyntax.fruitservice.Transaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParser {
    public List<Transaction> parseDate(List<String[]> inputData) {
        List<Transaction> transactions = new ArrayList<>();
        for (String[] strings : inputData) {
            transactions.add(new Transaction(strings[0], strings[1],
                    strings[2], strings[3]));
        }
        return transactions;
    }
}
