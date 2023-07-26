package core.basesyntax.service.impl;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReceivingHandler;
import core.basesyntax.service.ReportCreator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator<FruitTransaction> {
    public static final ReceivingHandler receivingHandler = new ReceivingHandlerImpl();

    @Override
    public String create(List<FruitTransaction> fruitTransactions) {
        checkFruitTransactionsForNull(fruitTransactions);
        Set<String> fruitsSet = getSetOfFruitNames(fruitTransactions);
        Map<String, Integer> report = createReportWithFruits(fruitsSet);
        fillReport(fruitTransactions, report);
        return formatReport(report);
    }

    private void checkFruitTransactionsForNull(List<FruitTransaction> fruitTransactions) {
        if (fruitTransactions == null) {
            throw new RuntimeException("Cannot create report with null");
        }
    }

    private Set<String> getSetOfFruitNames(List<FruitTransaction> fruitTransactions) {
        return fruitTransactions.stream()
                .map(FruitTransaction::getFruit)
                .collect(Collectors.toSet());
    }

    private Map<String, Integer> createReportWithFruits(Set<String> fruitsSet) {
        return fruitsSet.stream()
                .collect(Collectors.toMap(s -> s, i -> 0));
    }

    private void fillReport(List<FruitTransaction> fruitTransactions, Map<String, Integer> report) {
        checkReportForNull(report);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            String fruit = fruitTransaction.getFruit();
            int quantity = fruitTransaction.getQuantity();
            checkQuantityForNotPositiveNumber(quantity);

            OperationHandler handler = receivingHandler.getHandler(fruitTransaction.getOperation());
            handler.operation(fruit, quantity);
        }

        report.forEach((key, value) -> {
            if (value < 0) {
                throw new RuntimeException("Final amount of fruits \"" + key + "\" is "
                        + value + "! The number can't be negative");
            }
        });
    }

    @Override
    public String formatReport(Map<String, Integer> report) {
        StringBuilder formatReport = new StringBuilder();
        formatReport.append("fruit,quantity").append(System.lineSeparator());
        for (var entry : report.entrySet()) {
            formatReport.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return formatReport.toString();
    }

    private void checkReportForNull(Map<String, Integer> report) {
        if (report == null) {
            throw new RuntimeException("Report map is null. Cannot create report with null.");
        }
    }

    private void checkQuantityForNotPositiveNumber(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity should be a positive number: " + quantity);
        }
    }

}
