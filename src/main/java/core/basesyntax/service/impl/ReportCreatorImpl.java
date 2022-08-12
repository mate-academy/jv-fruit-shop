package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import java.util.List;

public class ReportCreatorImpl implements ReportCreator {
    private FruitsDao fruitsDao;

    public ReportCreatorImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public String createHeader(String firstColumn, String secondColumn) {
        return firstColumn + "," + secondColumn;
    }

    @Override
    public String create(String header) {
        List<Fruit> fruits = fruitsDao.getAll();
        StringBuilder reportBuilder = new StringBuilder(header);
        for (Fruit fruit : fruits) {
            reportBuilder.append(System.lineSeparator())
                    .append(fruit.getName())
                    .append(",")
                    .append(fruit.getQuantity());
        }
        return reportBuilder.toString();
    }
}
