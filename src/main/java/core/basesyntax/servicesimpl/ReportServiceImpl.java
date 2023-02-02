package core.basesyntax.servicesimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        Storage.fruitStorage.forEach((key, value) -> report
                .append(System.lineSeparator())
                .append(key)
                .append(",")
                .append(value));
        return report.toString();
    }
}
