package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DEFAULT_FIRST_LINE = "fruit,quantity" + System.lineSeparator();
    private static final char SEPARATOR = ',';

    @Override
    public String getReport(List<FruitTransaction> fruitTransactionList) {
        return DEFAULT_FIRST_LINE
                + fruitTransactionList.stream()
                .map(transaction -> transaction.getFruit() + SEPARATOR
                                + transaction.getQuantity())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
