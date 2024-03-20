package service;

import dto.FruitTransactionDto;
import java.util.List;

public interface FruitDataReaderService {
    List<FruitTransactionDto> read(String filePath);
}
