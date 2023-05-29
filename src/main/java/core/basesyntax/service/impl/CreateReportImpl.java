package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReport;
import core.basesyntax.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class CreateReportImpl implements CreateReport {
    private static final String TITLE_INFORMATION = "fruit,quantity";

    @Override
    public List<String> createReport(List<String> information) {
        List<String> lines = new ArrayList<>();
        lines.add(TITLE_INFORMATION);
        for (String record : information) {
            lines.add(record);
        }
        return lines;
    }
}
