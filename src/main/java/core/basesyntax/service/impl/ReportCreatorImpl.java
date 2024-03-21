package core.basesyntax.service.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.service.ReportCreator;
import java.util.ArrayList;
import java.util.List;

public class ReportCreatorImpl implements ReportCreator {

    public static final String TITLE = "product,quantity";
    public static final String COMMA = ",";

    @Override
    public List<String> create(ProductStorage storage) {
        List<String> reportLines = new ArrayList<>();
        reportLines.add(TITLE);
        reportLines.addAll(storage
                .getStorage()
                .entrySet()
                .stream()
                .map(e -> e.getKey() + COMMA + e.getValue())
                .toList());
        return reportLines;
    }
}
