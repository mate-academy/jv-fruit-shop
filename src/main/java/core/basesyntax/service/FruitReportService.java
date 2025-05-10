package core.basesyntax.service;

import core.basesyntax.model.FruitReport;
import java.util.List;

public interface FruitReportService {
    List<FruitReport> generateInventoryReport();
}
