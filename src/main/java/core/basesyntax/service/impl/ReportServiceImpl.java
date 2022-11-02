package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String CSV_OUTPUT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public List<String> generateReport(FruitStorage storage) {
        List<String> reportList = new ArrayList<>();
        reportList.add(CSV_OUTPUT_HEADER);
        storage.getStorage().forEach((key, value) -> reportList.add(key + SEPARATOR + value));
        return reportList;
    }
}
