package core.basesyntax.service;

import core.basesyntax.model.FruitReport;
import java.util.List;

public interface ReportService {

    String createReport(List<FruitReport> dataforReport);
}
