package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportCreator;
import java.util.ArrayList;
import java.util.List;

public class ReportCreatorImpl implements ReportCreator {

    public static final String TITLE = "fruit,quantity";
    public static final String COMMA = ",";

    @Override
    public List<String> create(FruitStorage storage) {
        List<String> reportLines = new ArrayList<>();
        reportLines.add(TITLE);
        reportLines.addAll(storage
                .storage()
                .entrySet()
                .stream()
                .map(e -> e.getKey().fruitName() + COMMA + e.getValue())
                .toList());
        return reportLines;
    }
}
