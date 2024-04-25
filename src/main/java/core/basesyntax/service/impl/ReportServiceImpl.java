package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String> calculateDataForReport(List<String> dateFromFile) {
        for (int i = 1; i < dateFromFile.size(); i++) {
            if (fruitDao.getFruit(dateFromFile.get(i)) == null) {
                fruitDao.addFruit(dateFromFile.get(i));
            } else {
                fruitDao.updateAmount(dateFromFile.get(i));
            }
        }
        return null;
    }
}
