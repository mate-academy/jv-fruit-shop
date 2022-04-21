package core.basesyntax.service.report;

import core.basesyntax.storage.Storage;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity\n");
        Storage.getDataBase().forEach((key, value) -> builder
                .append(key)
                .append(",")
                .append(value)
                .append(System.lineSeparator()));
        return builder.toString();
    }
}
