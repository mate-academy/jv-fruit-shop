package core.basesyntax.services;


import core.basesyntax.parsers.Transaction;
import core.basesyntax.parsers.TransactionList;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheet {
    public Map<String, Integer> getBalanceMap(String FilePath) {
        Map<String, Integer> balanceSheet = new HashMap<String, Integer>();
        List<Transaction> tr = new TransactionList().getAllTransactions(FilePath);
        for (Transaction t: tr) {
            if (t.getExpirationDate().isAfter(LocalDate.now())) {
                if (t.getOperaton() ==  "r" || t.getOperaton() ==  "s") {
                    balanceSheet.put(t.getFruitType(),t.getQuantity());
                }
            }
        }
        return balanceSheet;
    }
}
