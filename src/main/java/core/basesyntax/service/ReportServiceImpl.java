package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String> getReport() {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        report.addAll(fruitDao.getAll());
        return report;
    }
}
