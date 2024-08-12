package core.basesyntax.service.report;

import core.basesyntax.model.Fruit;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE_REPORT = "fruit,quantity";

    @Override
    public String getReport(List<Fruit> fruitList) {
        StringBuilder report = new StringBuilder();

        report.append(TITLE_REPORT).append(System.lineSeparator());
        fruitList.forEach(product -> report
                .append(product.getFruitName())
                .append(",")
                .append(product.getQuantity())
                .append(System.lineSeparator()));
        return report.toString();
    }
}
