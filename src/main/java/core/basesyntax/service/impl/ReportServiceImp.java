package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImp implements ReportService {
    @Override
    public List<String> createReport() {
        List<String> listReport = new ArrayList<>();
        for (Fruit fruit : Storage.fruits) {
            listReport.add(fruit.getName() + "," + fruit.getQuantity());
        }
        return listReport;
    }
}
