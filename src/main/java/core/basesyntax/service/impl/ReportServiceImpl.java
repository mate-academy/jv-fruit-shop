package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String FRUIT_QUANTITY = "fruit,quantity";
    private FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String makeReport() {
        List<Fruit> fruits = fruitDao.getAll();
        StringBuilder reportBuilder = new StringBuilder(FRUIT_QUANTITY)
                .append(System.lineSeparator());
        fruits.forEach(fruit -> reportBuilder.append(fruit.getFruitName())
                .append(",").append(fruit.getQuantity()).append(System.lineSeparator()));
        return reportBuilder.toString();
    }
}
