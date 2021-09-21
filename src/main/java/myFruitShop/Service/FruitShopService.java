package myFruitShop.Service;

import myFruitShop.model.OperationsDto;

import java.io.File;
import java.util.List;


public interface FruitShopService {
    void fruitStorageModifier(List<OperationsDto> dataInDto);
    File fileReportBuilder(String reportFileName);
}
