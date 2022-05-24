package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitReport;
import java.util.List;

public class FruitReportImpl implements FruitReport {
    private final FruitDao fruitDao;

    public FruitReportImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        List<Fruit> fruits = fruitDao.getAll();
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Fruit fruit : fruits) {
            report.append(System.lineSeparator()).append(fruit.getName())
                    .append(",").append(fruit.getAmount());
        }
        return report.toString();
    }
}
