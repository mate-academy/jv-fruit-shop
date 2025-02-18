package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneration;
import java.util.Map;

public class ReportGenerationImpl implements ReportGeneration {
    private static final String HEADER_FOR_RESULT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String reportGeneration() {
        final StringBuilder strBuild = new StringBuilder(HEADER_FOR_RESULT);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            strBuild.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue());
        }

        return strBuild.toString();
    }
}
