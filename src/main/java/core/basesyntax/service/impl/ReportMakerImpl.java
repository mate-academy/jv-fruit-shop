package core.basesyntax.service.impl;

import core.basesyntax.model.FruitBox;
import core.basesyntax.service.ReportMaker;
import java.util.List;

public class ReportMakerImpl implements ReportMaker {
    private static final String HEAD_OF_REPORT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String makingReport(List<FruitBox> fruitBoxes) {
        StringBuilder reportBuilder = new StringBuilder(HEAD_OF_REPORT);
        for (FruitBox fruitBox : fruitBoxes) {
            reportBuilder.append(System.lineSeparator())
                    .append(fruitBox.getFruitType())
                    .append(COMMA)
                    .append(fruitBox.getQuantity());
        }
        return reportBuilder.toString();
    }
}
