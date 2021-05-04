package service;

import java.util.List;
import model.dto.FruitRecordDto;

public interface ReportService {
    boolean makeStockReportToCsvFile(List<FruitRecordDto> dtos);
}
