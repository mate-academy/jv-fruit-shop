package core.basesyntax;

import core.basesyntax.services.BalanceSheet;
import core.basesyntax.services.Buy;
import core.basesyntax.services.Return;
import core.basesyntax.services.Supply;
import core.basesyntax.transactions.Transaction;
import core.basesyntax.transactions.TransactionList;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        new Buy().updateTransactionTable("example.csv", "orange",
                12, LocalDate.of(2021,11,23));
        new Supply().updateTransactionTable("example.csv", "banana",
                10, LocalDate.of(2021,10,23));
        new Return().updateTransactionTable("example.csv", "orange",
                100, LocalDate.of(2021,11,23));
        Map<String, Integer> map = new BalanceSheet().getBalanceMap("balanceTest.csv");
        Stream.of(map.toString())
                .forEach(System.out::println);
        List<Transaction> tr = new TransactionList().getAllTransactions("example.csv");
    }
}
