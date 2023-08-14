package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createReport(List<Fruit> fruits) {
        StringBuilder report = new StringBuilder("fruit,quantity").append(System.lineSeparator());
        for (Fruit fruit : fruits) {
            report.append(fruit.getName()).append(",").append(fruit.getQuantity()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
