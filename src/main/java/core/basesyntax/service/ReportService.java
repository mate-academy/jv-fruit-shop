package core.basesyntax.service;

import core.basesyntax.model.Product;
import java.util.Map;

public interface ReportService {
//    List<String> makeBalanceReport(Map<Product, Integer> balance);
    String makeReport(Map<Product, Integer> balance);
}
