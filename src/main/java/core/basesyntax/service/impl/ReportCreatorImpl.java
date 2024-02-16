package core.basesyntax.service.impl;

import core.basesyntax.Main;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Integer> entry :
                Main.getFruitStorage().getFruitInventory().entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(";");
        }
        return report.toString();
    }
}
