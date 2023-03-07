package core.basesyntax.service.impl;

import core.basesyntax.model.FruitDto;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(List<FruitDto> fruits) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (FruitDto element: fruits) {
            stringBuilder.append(element.getFruit()).append(",")
                    .append(element.getQuantity()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
