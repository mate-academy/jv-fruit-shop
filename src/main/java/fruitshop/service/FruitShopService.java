package fruitshop.service;

import fruitshop.model.OperationsDto;
import java.io.File;
import java.util.List;

public interface FruitShopService {
    void fruitStorageModifier(List<OperationsDto> dataInDto);

    File fileReportBuilder(String reportFileName);
}
