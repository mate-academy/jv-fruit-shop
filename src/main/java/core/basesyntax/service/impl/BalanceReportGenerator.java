package core.basesyntax.service.impl;

import core.basesyntax.db.BalanceStorageDao;
import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;

public class BalanceReportGenerator implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";

    private final BalanceStorageDao balanceStorage;

    public BalanceReportGenerator(BalanceStorageDao balanceStorage) {
        this.balanceStorage = balanceStorage;
    }

    @Override
    public List<String> getReport() {
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEADER);
        List<String> balanceRows = balanceStorage.getAll().stream()
                .map(item -> item.product().title() + "," + item.quantity())
                .toList();
        report.addAll(balanceRows);
        return report;
    }
}
