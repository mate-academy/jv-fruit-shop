package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ParseCsvServiceImpl;
import core.basesyntax.service.impl.ReadCsvServiceImpl;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        ReadCsvServiceImpl readTransactionService = new ReadCsvServiceImpl();
        List<String> csvStrings = readTransactionService.readCsvFile();
        ParseCsvServiceImpl parseTransactionService = new ParseCsvServiceImpl();
        parseTransactionService.getTransactions(csvStrings);

        Storage.transactions.stream()
                .map(FruitTransaction::toString)
                .forEach(System.out::println);
    }
}
