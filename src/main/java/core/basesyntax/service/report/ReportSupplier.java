package core.basesyntax.service.report;

import java.util.List;

public interface ReportSupplier {
    String getReport(List<String> records);
}
