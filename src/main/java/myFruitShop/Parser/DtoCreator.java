package myFruitShop.Parser;

import myFruitShop.model.OperationsDto;

import java.util.List;

public interface DtoCreator {
    List<OperationsDto> toDtoDataFormatter(List<String> rawRecords);
}
