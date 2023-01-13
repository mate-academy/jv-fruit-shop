package core.basesyntax.service.impl;

import core.basesyntax.db.StorageOfData;
import core.basesyntax.service.ReportBuilderService;
import java.util.Map;

public class ReportBuilderServiceImpl implements ReportBuilderService {

    @Override
    public String buildReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<String,Integer> entryMap : StorageOfData.fruitsData.entrySet()) {
            builder.append(entryMap.getKey())
                    .append(',')
                    .append(entryMap.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
