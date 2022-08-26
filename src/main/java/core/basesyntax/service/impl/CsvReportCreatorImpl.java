package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportCreator;
import java.util.List;

public class CsvReportCreatorImpl implements ReportCreator {
    private static final String REPORT_TITLE = "fruit,balance";
    private static final String SEPARATOR = ",";
    private final FruitService fruitService;

    public CsvReportCreatorImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public String makeReport() {
        List<Fruit> fruitList = fruitService.getAll();
        StringBuilder report = new StringBuilder(REPORT_TITLE);
        for (Fruit fruit : fruitList) {
            report.append(System.lineSeparator())
                    .append(fruit.getName())
                    .append(SEPARATOR)
                    .append(fruit.getAmount());
        }
        return report.toString();
    }
}
