package myFruitShop.Parser;

import myFruitShop.model.TransactionDto;

import java.util.List;

public interface DtoCreator {
    List<TransactionDto> toDtoDataFormatter(List<String> rawRecords);
}
