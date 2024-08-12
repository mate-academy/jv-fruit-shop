package core.basesyntax.service.report;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ReportGenerator {
    String getReport(List<Fruit> fruitList);
}
