package core.basesyntax.service.impl;

import core.basesyntax.model.FruitCrate;
import core.basesyntax.service.ReportMaker;
import java.util.Comparator;
import java.util.List;

public class ReportMakerImpl implements ReportMaker {
    @Override
    public String makeReport(List<FruitCrate> storage) {
        Comparator<FruitCrate> fruitCrateComparator =
                Comparator.comparing(FruitCrate::getName);
        storage.sort(fruitCrateComparator);
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity");
        for (FruitCrate fruitCrate : storage) {
            reportBuilder.append(System.lineSeparator()).append(fruitCrate.getName()).append(",")
                    .append(fruitCrate.getQuantity());
        }
        return reportBuilder.toString();
    }
}
