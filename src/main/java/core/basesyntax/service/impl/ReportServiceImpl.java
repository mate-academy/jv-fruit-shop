package core.basesyntax.service.impl;

import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.strategy.TypeActivityStrategy;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String CSV_SEPARATOR = ",";
    private static final String CSV_HEAD_REPORT = "fruit,quantity";
    private static final String CSV_END_LINE = System.lineSeparator();
    private final ActivityDaoDb activityDaoDb;
    private final TypeActivityStrategy typeActivityStrategy;

    public ReportServiceImpl(ActivityDaoDb activityDaoDb,
                             TypeActivityStrategy typeActivityStrategy) {
        this.activityDaoDb = activityDaoDb;
        this.typeActivityStrategy = typeActivityStrategy;
    }

    @Override
    public String makeReport() {
        return CSV_HEAD_REPORT + CSV_END_LINE
            + activityDaoDb.getAll().stream()
                    .collect(Collectors.groupingBy(
                            FruitTransaction::getFruit,
                            Collectors.summingInt(v ->
                                typeActivityStrategy.get(v.getType()).prepareCount(v.getCount())
                            )
                    ))
                    .entrySet().stream()
                    .map(e -> e.getKey() + CSV_SEPARATOR + e.getValue())
                    .collect(Collectors.joining(CSV_END_LINE));
    }
}
