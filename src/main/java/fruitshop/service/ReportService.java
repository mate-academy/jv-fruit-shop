package fruitshop.service;

import fruitshop.model.Fruit;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public interface ReportService {
    String generateReport(Set<Map.Entry<Fruit, BigDecimal>> report);
}
