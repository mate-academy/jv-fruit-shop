package core.basesyntax.service.parser.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.parser.ParserMapService;
import java.util.Map;

public class ParserMapServiceImpl implements ParserMapService {
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getStringFromFruitsComposition() {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_TITLE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> pair : Storage.getFruitsComposition().entrySet()) {
            builder.append(pair.getKey()).append(COMMA).append(pair.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
