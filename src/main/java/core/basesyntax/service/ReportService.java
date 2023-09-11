package core.basesyntax.service;

import core.basesyntax.model.FruitInStorage;
import java.util.List;

public interface ReportService {
    String generateReport(List<FruitInStorage> fruits);
}
