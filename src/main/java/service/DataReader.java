package service;

import java.util.List;
import model.FruitTransactionDto;

public interface DataReader {
    List<FruitTransactionDto> readFromFile(String fileName);
}
