package core.basesyntax.services;

import core.basesyntax.transactions.Transaction;
import core.basesyntax.transactions.TransactionList;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceSheet {
    public Map<String, Integer> getBalanceMap(String filePath) {
        List<Transaction> transactionList = new TransactionList().getAllTransactions(filePath);
        Map<String, Integer> balanceSheet = transactionList.stream()
                    .filter(x -> x.getExpirationDate().isAfter(LocalDate.now()))
                    .collect(Collectors.groupingBy(x -> x.getFruitType(),
                            Collectors.summingInt(Transaction::getQuantity)));
        return balanceSheet;
    }
}
