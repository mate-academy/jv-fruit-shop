package fruitshop.model.dto;

import fruitshop.model.Fruit;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class ReportDto {
    private final Set<Map.Entry<Fruit, BigDecimal>> report;

    public ReportDto(Set<Map.Entry<Fruit, BigDecimal>> report) {
        this.report = report;
    }

    public Set<Map.Entry<Fruit, BigDecimal>> getReportDto() {
        return report;
    }
}
