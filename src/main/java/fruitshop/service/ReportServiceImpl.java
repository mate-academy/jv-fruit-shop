package fruitshop.service;

import fruitshop.model.Fruit;
import fruitshop.model.dto.ReportDto;
import java.math.BigDecimal;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_COLUMN_NAME = "fruit";
    private static final String SECOND_COLUMN_NAME = "quantity";
    private static final String DELIMITER = ",";

    @Override
    public String generateReport(ReportDto reportDto) {
        StringBuilder reportString = new StringBuilder(FIRST_COLUMN_NAME
                + DELIMITER + SECOND_COLUMN_NAME + System.lineSeparator());
        for (Map.Entry<Fruit, BigDecimal> mapEntry : reportDto.getReportDto()) {
            reportString.append(mapEntry.getKey().getFruitName())
                    .append(DELIMITER)
                    .append(mapEntry.getValue())
                    .append(System.lineSeparator());
        }
        return reportString.toString().trim();
    }
}
