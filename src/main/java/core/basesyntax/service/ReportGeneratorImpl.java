package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private final static String DEFAULT_FIRST_LINE = "fruit,quantity\n";

    @Override
    public String getReport(List<FruitTransaction> fruitTransactionList) {
        return DEFAULT_FIRST_LINE
                + fruitTransactionList.stream()
                .map(transaction -> transaction.getFruit() + ","
                                + transaction.getQuantity())
                .collect(Collectors.joining("\n"));
    }
}
