package core.basesyntax.parsers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionList {

    public List<Transaction> getAllTransactions(String FilePath) {
        List<Transaction> empList = new ArrayList<>();
        List<String[]> fromCSV = new ParseFromCSV().parseFromCSV(FilePath);
        for (String[] line : fromCSV) {
                Transaction transaction =
                        new Transaction(line[0], line[1], Integer.valueOf(line[2]),
                                LocalDate.parse(line[3]));
                empList.add(transaction);
        }
        return empList;
    }

}
