package core.basesyntax.transactions;

import core.basesyntax.parsers.ParseFromFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionList {

    public List<Transaction> getAllTransactions(String filePath) {
        List<Transaction> summery = new ArrayList<>();
        List<String[]> dataFromFile = new ParseFromFile().parseFromFile(filePath);
        for (String[] line : dataFromFile) {
            Transaction transaction = new Transaction(line[0], line[1],
                    Integer.valueOf(line[2]), LocalDate.parse(line[3]));
            summery.add(transaction);
        }
        return summery;
    }
}
