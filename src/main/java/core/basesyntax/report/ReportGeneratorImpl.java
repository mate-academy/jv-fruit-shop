package core.basesyntax.report;

import core.basesyntax.storage.FruitShop;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR_COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER).append(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry : FruitShop.storage.entrySet()) {
            sb.append(entry.getKey())
                    .append(SEPARATOR_COMMA)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return sb.toString();
    }
}
