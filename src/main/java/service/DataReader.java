package service;

import model.Fruit;
import model.FruitTransactionDto;

import java.util.List;

public interface DataReader {
    List<FruitTransactionDto> readFromFile(String fileName);
}
