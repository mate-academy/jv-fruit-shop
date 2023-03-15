package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ReportService {
    public String generateReport(List<Fruit> fruitList);
}
