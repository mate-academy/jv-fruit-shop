package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> listReport = new ArrayList<>();
        listReport.add(FIRST_LINE);
        for (Fruit fruit : Storage.fruits) {
            listReport.add(fruit.getName() + "," + fruit.getQuantity());
        }
        return listReport;
    }
}
