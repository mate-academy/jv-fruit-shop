package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGeneration;
import java.util.Map;

public class ReportGenerationImpl implements ReportGeneration {

    @Override
    public String generateReport(Map<String, Integer> map) {
        StringBuilder contentToWrite = new StringBuilder();
        return contentToWrite.append("fruit,quantity")
                .append(System.lineSeparator())
                .append("banana,")
                .append(map.get("banana"))
                .append(System.lineSeparator())
                .append("apple,")
                .append(map.get("apple")).toString();
    }
}
