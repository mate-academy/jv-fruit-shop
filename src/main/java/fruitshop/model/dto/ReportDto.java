package fruitshop.model.dto;

import fruitshop.model.Fruit;
import java.util.Map;
import java.util.Set;

public class ReportDto {
    private final Set<Map.Entry<Fruit, Integer>> report;

    public ReportDto(Set<Map.Entry<Fruit, Integer>> report) {
        this.report = report;
    }

    public Set<Map.Entry<Fruit, Integer>> getReport() {
        return report;
    }
}
