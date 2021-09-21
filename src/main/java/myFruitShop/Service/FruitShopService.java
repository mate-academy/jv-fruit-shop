package myFruitShop.Service;

import myFruitShop.model.TransactionDto;

import java.io.File;
import java.util.List;


public interface FruitShopService {
    void fruitStorageModifier(List<TransactionDto> dataInDto);
    File fileReportBuilder();

}
