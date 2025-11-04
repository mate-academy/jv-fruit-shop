package core.basesyntax.services.impl;

import core.basesyntax.services.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    static final String String_Separator = ",";
    static final String Header = "fruit,quantity";

    @Override
    public String getReport(Map<String, Integer> transactions) {
        StringBuilder sb = new StringBuilder();
        sb.append(Header);
        sb.append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : transactions.entrySet()) {
            sb.append(entry.getKey())
                    .append(String_Separator)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
