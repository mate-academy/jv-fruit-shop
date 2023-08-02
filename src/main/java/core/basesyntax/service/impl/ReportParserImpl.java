package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.interfaces.TransactionParser;
import java.util.Map;

public class ReportParserImpl implements TransactionParser<String, Map<Fruit, Integer>> {
    private static final String REPORT_HEADING = "fruit,quantity\r\n";
    private static final String COMMA = ",";

    @Override
    public String parse(Map<Fruit, Integer> data) {
        StringBuilder report = new StringBuilder().append(REPORT_HEADING);
        for (Map.Entry<Fruit, Integer> entry : data.entrySet()) {
            report.append(entry.getKey().name().toLowerCase())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
