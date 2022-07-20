package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String makeReport(List<Fruit> fruits) {
        String header = "fruit,quantity";
        String balanceString = fruits.stream()
                .map(p -> (p.getType() + "," + p.getQuantity()))
                .collect(Collectors.joining(System.lineSeparator()));
        return header + System.lineSeparator() + balanceString;
    }
}
