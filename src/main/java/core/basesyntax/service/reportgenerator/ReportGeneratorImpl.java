package core.basesyntax.service.reportgenerator;

import core.basesyntax.db.ShopDataBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> generateReport() {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : ShopDataBase.getMapEntrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            report.add(stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue()).toString());
        }
        return report;
    }
}
