package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Collection;

public interface ReportService {
    String createReport(Collection<Fruit> fruitList);
}
