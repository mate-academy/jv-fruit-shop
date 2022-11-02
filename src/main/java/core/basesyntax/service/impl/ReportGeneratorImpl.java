package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMMA = ",";
    private static final String FRUIT_QUANTITY = "fruit,quantity";
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(FRUIT_QUANTITY).append(System.lineSeparator());
        List<Fruit> allFruit = fruitDao.getAll();
        for (Fruit fruit : allFruit) {
            builder.append(fruit.getTypeOfFruit())
                    .append(COMMA)
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
