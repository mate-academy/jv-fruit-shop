package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String makeReport(Map<Fruit, Integer> balance) {
        String header = "fruit,quantity";
        String balanceString = balance.entrySet().stream()
                .map(p -> (p.getKey().getType() + "," + p.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
        return header + System.lineSeparator() + balanceString;
    }
}
