package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDb;
import core.basesyntax.model.ReportRecord;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private final FruitDb db;

    public ReportServiceImpl(FruitDb db) {
        this.db = db;
    }

    @Override
    public List<ReportRecord> generate() {
        return db.getEntrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .map(entry -> new ReportRecord(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
