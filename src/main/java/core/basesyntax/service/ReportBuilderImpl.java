package core.basesyntax.service;

import static core.basesyntax.enums.Operation.BALANCE;
import static core.basesyntax.enums.Operation.PURCHASE;
import static core.basesyntax.enums.Operation.RETURN;
import static core.basesyntax.enums.Operation.SUPPLY;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ReportBuilderImpl implements ReportBuilder {
    private static final java.lang.String COMMA = ",";
    private static final java.lang.String TITLE_RECORD = "fruit,quantity" + System.lineSeparator();

    @Override
    public List<String> getReport(List<FruitTransaction> transactions) {
        List<java.lang.String> records = transactions.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .map(fruit -> createRecord(fruit, transactions))
                .collect(Collectors.toList());
        records.add(0, TITLE_RECORD);
        return records;
    }

    private String createRecord(String fruit, List<FruitTransaction> transactions) {
        StringBuilder recordBuilder = new StringBuilder();
        int openBalance = getOpenBalance(fruit, transactions);
        int turnoverIn = getTurnoverIn(fruit, transactions);
        int turnoverOut = getTurnoverOut(fruit, transactions);
        int closingBalance = openBalance + turnoverIn - turnoverOut;
        return recordBuilder.append(fruit)
                .append(COMMA).append(closingBalance)
                .append(System.lineSeparator()).toString();
    }

    private int getTurnoverOut(String fruit, List<FruitTransaction> transactions) {
        return transactions.stream()
                .filter(transaction ->
                        transaction.getFruit().equals(fruit)
                                && transaction.getOperation().equals(PURCHASE))
                .map(FruitTransaction::getQuantity)
                .reduce(0, Integer::sum);
    }

    private int getTurnoverIn(String fruit, List<FruitTransaction> transactions) {
        return transactions.stream()
                .filter(transaction ->
                        transaction.getFruit().equals(fruit)
                                && (transaction.getOperation().equals(SUPPLY)
                                || transaction.getOperation().equals(RETURN)))
                .map(FruitTransaction::getQuantity)
                .reduce(0, Integer::sum);
    }

    private int getOpenBalance(String fruit, List<FruitTransaction> transactions) {
        return transactions.stream()
                .filter(transaction ->
                        transaction.getFruit().equals(fruit)
                                && transaction.getOperation().equals(BALANCE))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't find opening balance for " + fruit))
                .getQuantity();
    }
}
