package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String TABLE_HEADER = "fruits,quantity";
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();

        report.add(TABLE_HEADER);
        fruitDao.getDataBaseContent().entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue())
                .sorted()
                .forEach(report::add);

        return report;
    }
}
