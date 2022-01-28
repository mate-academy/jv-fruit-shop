package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.GenerateReport;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GenerateReportImpl implements GenerateReport {
    @Override
    public String reportGenerater(List<FruitTransaction> fruitTransactions) {
        return fruitTransactions.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit, Collectors.summingInt(this::summFruits)))
                .entrySet()
                .stream().map(m -> new StringBuilder()
                        .append(m.getKey())
                        .append(",")
                        .append(m.getValue())).collect(Collectors.joining(System.lineSeparator()));
    }

    private int summFruits(FruitTransaction fruitTransaction) {
        int balance = 0;
        if (fruitTransaction.getOperation() == FruitTransaction.Operation.BALANCE) {
            balance += fruitTransaction.getQuantity();
        }
        if (fruitTransaction.getOperation() == FruitTransaction.Operation.SUPPLY) {
            balance += fruitTransaction.getQuantity();
        }
        if (fruitTransaction.getOperation() == FruitTransaction.Operation.RETURN) {
            balance += fruitTransaction.getQuantity();
        }
        if (fruitTransaction.getOperation() == FruitTransaction.Operation.PURCHASE) {
            balance -= fruitTransaction.getQuantity();
        }
        return balance;
    }
}
