package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.SeparateService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SeparateServiceImpl implements SeparateService {
    public static final String HEADER = "fruit,quantity";

    @Override
    public List<String> getReportFromList() {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER)
                .append(System.lineSeparator());
        List<String> fromMapToList = new ArrayList<>();
        for (Map.Entry<String, Integer> output : Storage.fruitStorage.entrySet()) {
            builder.append(output.getKey())
                    .append(",")
                    .append(output.getValue())
                    .append(System.lineSeparator());
            fromMapToList.add(builder.toString());
        }
        return fromMapToList;
    }
}
