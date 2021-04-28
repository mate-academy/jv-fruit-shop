package core.basesyntax.data.impl;

import core.basesyntax.data.ReportCreator;
import core.basesyntax.storage.FruitDataBase;
import java.util.Map;

public class FruitShopReportCreator implements ReportCreator {
    private final FruitDataBase fruitDataBase;

    public FruitShopReportCreator(FruitDataBase fruitDataBase) {
        this.fruitDataBase = fruitDataBase;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entrySet : fruitDataBase.getDataBaseCopy().entrySet()) {
            report.append(entrySet.getKey()).append(", ").append(entrySet.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
