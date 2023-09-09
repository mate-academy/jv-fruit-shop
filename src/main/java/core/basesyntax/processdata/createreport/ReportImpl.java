package core.basesyntax.processdata.createreport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportImpl implements Report {
    private final String fruitColumnName = "fruit";
    private final String fruitAmountColumnName = "quantity";
    private final String columnSeparator = ",";

    @Override
    public List<String> createReport(Map<String, Integer> stock) {
        List<String> report = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(fruitColumnName).append(columnSeparator).append(fruitAmountColumnName);
        report.add(sb.toString());
        for (Map.Entry<String, Integer> product : stock.entrySet()) {
            sb = new StringBuilder();
            sb.append(product.getKey()).append(columnSeparator).append(product.getValue());
            report.add(sb.toString());
        }
        return report;
    }
}
