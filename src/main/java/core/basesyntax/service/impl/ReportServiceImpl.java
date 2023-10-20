package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(HEADER);

        for (Fruit fruit : fruitDao.getAll()) {
            report.add(fruit.getName() + "," + fruit.getQuantity());
        }

        return report;
    }
}
