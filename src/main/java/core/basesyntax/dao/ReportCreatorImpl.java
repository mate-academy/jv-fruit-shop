package core.basesyntax.dao;

import core.basesyntax.dbreport.Report;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String createReport() {
        String eol = System.getProperty("line.separator");
        StringBuilder report = new StringBuilder();
        report.append("fruit")
                .append(',')
                .append("quantity")
                .append(eol);
        for (Map.Entry<String, Integer> entry : Report.report.entrySet()) {
            report.append(entry.getKey())
                    .append(',')
                    .append(entry.getValue().toString())
                    .append(eol);
        }
        return report.toString();
    }
}
