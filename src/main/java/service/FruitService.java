package service;

import java.util.List;
import model.Fruit;
import model.TransactionDto;

public interface FruitService {
    List<Fruit> changeBalance(List<TransactionDto> transactions);
}
