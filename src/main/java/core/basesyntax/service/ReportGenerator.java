package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ReportGenerator {
    String generateReport(List<Fruit> fruits);
}
