package fruitshop.service;

import fruitshop.model.dto.ReportDto;

public interface ReportService {
    String generateReport(ReportDto reportDto);
}
