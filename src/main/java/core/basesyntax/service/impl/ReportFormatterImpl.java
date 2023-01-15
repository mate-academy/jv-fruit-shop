package core.basesyntax.service.impl;

import java.util.ArrayList;
import java.util.List;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportFormatter;

public class ReportFormatterImpl implements ReportFormatter {
    @Override
    public List<String> makeReport() {
        FruitDao fruitDao = new FruitDaoImpl();
        List<String> report = new ArrayList<>();

        report.add("```text" + System.lineSeparator() 
                + "    fruit,quantity");
        List<Fruit> fruitList = fruitDao.getFruitList();
        for (Fruit fruit : fruitList) {
            report.add("    " + fruit.getName() + ',' + fruit.getQuantity());
        }
        report.add("```");
        return report;
    }
}
