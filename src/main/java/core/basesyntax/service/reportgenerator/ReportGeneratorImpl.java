package core.basesyntax.service.reportgenerator;

import static core.basesyntax.db.ShopDataBase.SHOP_DATA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String HEADER = "fruit,quantity";
    public static final String DELIMITER = ",";

    @Override
    public List<String> generateReport() {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        for (Map.Entry<String, Integer> entry : SHOP_DATA.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            report.add(stringBuilder.append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue()).toString());
        }
        return report;
    }
}
