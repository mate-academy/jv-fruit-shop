package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import java.util.List;

public interface ReportService {
    List<String> generateReport(FruitStorage storage);
}
