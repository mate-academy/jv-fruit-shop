package core.basesyntax.report.report;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public interface ReportGenerator {
    String getReport(List<FruitOperation> store);
}
