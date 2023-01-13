package core.basesyntax.service.impl;

import core.basesyntax.db.StorageOfData;
import core.basesyntax.service.ReportBuilderService;
import java.util.Map;

public class ReportBuilderServiceImpl implements ReportBuilderService {

    @Override
    public String buildReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity");
        for (Map.Entry<String,Integer> entryMap : StorageOfData.fruitsData.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(entryMap.getKey())
                    .append(',')
                    .append(entryMap.getValue());
        }
        return builder.toString();
    }
}
