package core.basesyntax.service.report;

import core.basesyntax.model.FruitRecord;
import java.util.List;

public interface ReportService {
    String getReport(List<FruitRecord> fruitRecords);
}
