package core.basesyntax.service.impl;

import core.basesyntax.service.ReportMakerService;
import java.util.Map;

public class ReportMakerServiceImpl implements ReportMakerService {

    private static final String HEAD_LINER = "fruit, quantity";

    @Override
    public String report(Map<String, Integer> report) {
        StringBuilder builder = new StringBuilder();
        builder.append(HEAD_LINER);
        report.forEach((key, value) -> builder
                .append(System.lineSeparator())
                .append(key).append(", ").append(value));
        return builder.toString();
    }
}
