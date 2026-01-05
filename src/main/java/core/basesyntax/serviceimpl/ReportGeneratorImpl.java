package core.basesyntax.serviceimpl;

import core.basesyntax.db.Inventory;
import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit, quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public List<String> getReport(Inventory inventory) {
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEADER);

        Map<String, Integer> fruits = inventory.getAllFruits();
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.add(entry.getKey() + COMMA_SEPARATOR + entry.getValue());
        }
        return report;
    }
}
