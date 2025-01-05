package core.basesyntax.services.impl;

import core.basesyntax.services.ReportGenerator;

import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            stringBuilder.append(string).append("\n");
        }
        return stringBuilder.toString();
    }
}
