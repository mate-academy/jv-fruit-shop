package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportsService;

import java.util.ArrayList;
import java.util.List;

public class EndOfTheDayReport implements ReportsService {
    private final String FIRST_LINE = "fruit,quantity";
    @Override
    public List<String> getReport() {
        List<String> report = new ArrayList<>();
        report.add(FIRST_LINE);
        Storage.getFruitsStorage()
                .forEach((key, value) -> report.add(key + "," + value));
        return report;
    }
}
