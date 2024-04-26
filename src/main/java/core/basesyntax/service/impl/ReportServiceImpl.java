package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void calculateDataForReport(List<String> dateFromFile) {
        for (int i = 1; i < dateFromFile.size(); i++) {
            String line = dateFromFile.get(i);
            if (fruitDao.getFruit(line) == null) {
                fruitDao.addFruit(line);
            } else {
                fruitDao.updateAmount(line);
            }
        }
    }
}
