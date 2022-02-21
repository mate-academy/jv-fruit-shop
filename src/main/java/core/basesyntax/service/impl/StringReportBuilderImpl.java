package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StringReportBuilder;
import java.util.Map;
import java.util.Set;

public class StringReportBuilderImpl implements StringReportBuilder {
    @Override
    public String buildReport() {
        Set<Map.Entry<Fruit, Integer>> fruitSet = new FruitDaoImpl().getDataFromStorage();
        StringBuilder reportBuilder = new StringBuilder()
                .append("fruit,quantity");
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : fruitSet) {
            reportBuilder
                    .append(System.lineSeparator())
                    .append(fruitIntegerEntry.getKey().getName())
                    .append(",")
                    .append(fruitIntegerEntry.getValue());
        }
        return reportBuilder.toString();
    }
}
