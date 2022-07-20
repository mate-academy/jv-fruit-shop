package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ReportService {
    String makeReport(List<Fruit> fruits);
}
