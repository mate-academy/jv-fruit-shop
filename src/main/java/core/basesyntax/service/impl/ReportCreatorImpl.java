package core.basesyntax.service.impl;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReceiveHandler;
import core.basesyntax.service.ReportCreator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator<FruitTransaction> {
    private static final String FIRST_LINE_OF_REPORT = "fruit,quantity";
    private final ReceiveHandler receiveHandler;

    {
        receiveHandler = new ReceiveHandlerImpl();
    }

    @Override
    public String formatReport(Map<String, Integer> report) {
        checkQuantityInReport(report);
        StringBuilder formatReport = new StringBuilder();
        formatReport.append(FIRST_LINE_OF_REPORT).append(System.lineSeparator());

        String reportString = report.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));

        formatReport.append(reportString);
        return formatReport.toString();
    }

    @Override
    public String create(List<FruitTransaction> fruitTransactions) {
        checkFruitTransactionsForNull(fruitTransactions);
        Set<String> fruitsSet = getSetOfFruitNames(fruitTransactions);
        Map<String, Integer> report = createReportWithFruits(fruitsSet);
        fillReport(fruitTransactions);
        String result = formatReport(report);
        return result;
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
                .collect(Collectors.toMap(string -> string, iterator -> 0));
    }

    private void fillReport(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            String fruit = fruitTransaction.getFruit();
            int quantity = fruitTransaction.getQuantity();
            checkQuantity(quantity);

            OperationHandler handler = receiveHandler.getHandler(fruitTransaction.getOperation());
            handler.handle(fruit, quantity);
        }
    }

    private void checkQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity should be a positive number: " + quantity);
        }
    }

    private void checkQuantityInReport(Map<String, Integer> report) {
        report.forEach((key, value) -> {
            if (value < 0) {
                throw new RuntimeException("Final amount of fruits \"" + key + "\" is "
                        + value + "! The number can't be negative");
            }
        });
    }

}
