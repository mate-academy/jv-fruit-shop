package core.basesyntax.service;

import core.basesyntax.model.Product;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String makeReport(Map<Product, Integer> balance) {
        String header = "product,quantity";
        String balanceString = balance.entrySet().stream()
                .map(p -> (p.getKey().getType() + "," + p.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
        return header + System.lineSeparator() + balanceString;
    }
}
