package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitReport;
import core.basesyntax.service.FruitService;

import java.util.List;

public class FruitReportImpl implements FruitReport {
    private static final String REPORT_TITLE = "fruit,balance";
    private static final String SEPARATOR = ",";
    private final FruitService fruitService;

    public FruitReportImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public String makeReport() {
        List<Fruit> fruitList = fruitService.getAll();
        StringBuilder report = new StringBuilder(REPORT_TITLE);
        for (Fruit fruit:fruitList) {
            report.append(System.lineSeparator())
                    .append(fruit.getName())
                    .append(SEPARATOR)
                    .append(fruit.getAmount());
        }
        return report.toString();
    }
}
