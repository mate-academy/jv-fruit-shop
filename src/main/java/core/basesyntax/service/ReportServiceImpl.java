package core.basesyntax.service;

import core.basesyntax.model.Product;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<String> makeBalanceReport(Map<Product, Integer> balance) {
            return balance.entrySet().stream()
                    .map(p -> (p.getKey().getType() + "," + p.getValue()))
                    .collect(Collectors.toList());
    }
}
