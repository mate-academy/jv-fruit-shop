package core.basesyntax.service.impl;

import core.basesyntax.service.GenerateBalanceReport;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerateFruitsBalanceReport implements GenerateBalanceReport {
    private static final String REPORT_TITLE = "fruit,quantity" + System.lineSeparator();

    @Override
    public String getReport(Map<String, Integer> balance) {
        return REPORT_TITLE
                + balance.entrySet().stream()
                .map(b -> b.getKey() + "," + b.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
