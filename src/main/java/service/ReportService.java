package service;

import model.dto.FruitRecordDto;

import java.util.List;

public interface ReportService {
    boolean makeStockReportToCSVFile(List<FruitRecordDto> dtos);
}
