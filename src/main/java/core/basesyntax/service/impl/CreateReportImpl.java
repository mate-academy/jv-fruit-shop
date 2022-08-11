package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreateReport;
import java.util.List;

public class CreateReportImpl implements CreateReport {
    private static final String REPORT_TITLE = "fruit,quantity";
    private FruitsDao fruitsDao;

    public CreateReportImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public String get() {
        List<Fruit> fruits = fruitsDao.getAll();
        StringBuilder reportBuilder = new StringBuilder(REPORT_TITLE);
        for (Fruit fruit : fruits) {
            reportBuilder.append(System.lineSeparator())
                    .append(fruit.getName())
                    .append(",")
                    .append(fruit.getQuantity());
        }
        return reportBuilder.toString();
    }
}
