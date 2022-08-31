package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGeneration;
import java.util.Map;

public class ReportGenerationImpl implements ReportGeneration {

    @Override
    public String generateReport(Map<Fruit,Integer> map) {
        StringBuilder contentToWrite = new StringBuilder();
        contentToWrite.append("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit,Integer> entry : map.entrySet()) {
            contentToWrite.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return contentToWrite.toString();
    }
}
