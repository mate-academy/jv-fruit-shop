package core.basesyntax;

import com.opencsv.exceptions.CsvException;
import core.basesyntax.parsers.ParseToCSV;
import core.basesyntax.parsers.Transaction;

import core.basesyntax.services.BalanceSheet;
import core.basesyntax.services.Supply;
import java.io.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, CsvException {

        Transaction trTest = new Transaction("s","banana",90,LocalDate.of(2003,11,23));
        boolean strin = new ParseToCSV().writeToFile(trTest, "example.csv");
        Map<String, Integer> map = new BalanceSheet().getBalanceMap("example.csv");
        Stream.of(map.values().toString())
                .forEach(System.out::println);
        boolean str = new Supply().UpdateTransactionTable("example.csv", "orange", 12, LocalDate.of(2013,11,23));

       // List<Transaction> tr = new TransactionList().getAllTransactions();
        System.out.println(map.get("banana"));
    }


}
