package core.basesyntax.service.impl;

import static core.basesyntax.db.Storage.getFruitShop;

import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Integer> e : getFruitShop().entrySet()) {
            report.append(e.getKey())
                    .append(",")
                    .append(e.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
