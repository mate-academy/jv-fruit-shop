package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";

    @Override
    public String createFruitBalanceReport(Map<String, Integer> fruitBalance) {
        StringBuilder reportBuilder = new StringBuilder("fruit")
                .append(SEPARATOR).append("quantity").append(System.lineSeparator());

        for (Map.Entry<String, Integer> balance : fruitBalance.entrySet()) {
            if (balance.getValue() < 0) {
                throw new RuntimeException("Fruit quantity can`t be less than 0");
            }
            reportBuilder.append(balance.getKey()).append(SEPARATOR)
                    .append(balance.getValue()).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
