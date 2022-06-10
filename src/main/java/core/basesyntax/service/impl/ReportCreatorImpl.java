package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.service.ReportCreator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportCreatorImpl() {
        fruitDao = new FruitDaoImpl();
    }

    public List<String> createReportList() {
        List<String> report = new ArrayList<>();
        report.add(HEADER + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitDao.getStorage().entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
        }
        return report;
    }
}
