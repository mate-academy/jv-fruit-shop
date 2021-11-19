package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface CreateReportService {
    String createReport(List<Fruit> fruits);
}
