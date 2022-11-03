package fruitshop.service.impl;

import fruitshop.model.FruitReport;
import fruitshop.service.ReportGeneratorService;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ROW_DELIMITER = ",";

    public String generate(List<FruitReport> reportList) {
        return reportList
                    .stream()
                    .map(r -> r.getFruitName() + ROW_DELIMITER + r.getQuantity())
                    .collect(Collectors.joining(LINE_SEPARATOR));
    }
}
