package core.basesyntax.service.impl;

import core.basesyntax.model.FruitReport;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {

    private static final String SEPARATOR = System.lineSeparator();

    @Override
    public String createReport(List<FruitReport> dataforReport) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity");
        for (FruitReport data : dataforReport) {
            builder.append(SEPARATOR)
                    .append(data.getFruit())
                    .append(",")
                    .append(data.getQuantity());
        }
        return builder.toString();
    }
}
