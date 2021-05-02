package fruitshop.dao;

import fruitshop.model.dto.FruitOperationDto;
import fruitshop.model.dto.ReportDto;
import java.math.BigDecimal;

public interface FruitStorageDao {
    BigDecimal getValueFromStorage(FruitOperationDto fruitOperationDto);

    void updateDataInStorage(FruitOperationDto fruitOperationDto);

    ReportDto getDataReportFromStorage();
}
