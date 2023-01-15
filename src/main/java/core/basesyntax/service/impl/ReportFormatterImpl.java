package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReportFormatterImpl implements ReportFormatter {
    @Override
    public List<String> makeReport() {
        FruitDao fruitDao = new FruitDaoImpl();
        List<String> report = new ArrayList<>();

        report.add("fruit,quantity");
        List<Fruit> fruitList = fruitDao.getFruitList();
        for (Fruit fruit : fruitList) {
            report.add(fruit.getName() + ',' + fruit.getQuantity());
        }
        return report;
    }
}
