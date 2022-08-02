package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        report.append(System.lineSeparator());
        List<Fruit> fruits = fruitDao.getAll();
        for (Fruit fruit : fruits) {
            report.append(fruit.getName()).append(",")
                    .append(fruit.getAmount())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
