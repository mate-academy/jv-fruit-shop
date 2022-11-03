package fruitshop.service;

import fruitshop.model.FruitReport;
import java.util.List;

public interface ReportGeneratorService {
    String generate(List<FruitReport> reportList);
}
