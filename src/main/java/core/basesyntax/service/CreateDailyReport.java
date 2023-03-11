package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CreateDailyReport {
    public static final String SEPARATE_SYMBOL_FOR_CSV =
            ProcessDailyTransactions.SEPARATE_SYMBOL_FOR_CSV;
    private static final String HEAD_OF_REPORT_TABLE = "fruit,quantity";

    public List<String> createReport(List<Transaction> transactionList) {
        List<String> fruitsListToReport = new ArrayList<>();
        Stream.of(Fruit.values())
                .forEach(f -> fruitsListToReport.add(f.getFruitName()
                        + SEPARATE_SYMBOL_FOR_CSV
                        + totalBalanceByOneProduct(transactionList, f)));
        fruitsListToReport.add(0, HEAD_OF_REPORT_TABLE);
        return fruitsListToReport;
    }

    private int totalBalanceByOneProduct(List<Transaction> transactionsList, Fruit fruit) {
        return transactionsList.stream()
                .filter(t -> t.getFruit().getFruitName().equals(fruit.getFruitName()))
                .mapToInt(t -> t.getAmount() * t.getOperation().getFruitDirection())
                .sum();
    }
}
