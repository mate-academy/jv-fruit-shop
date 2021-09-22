package service;

import java.util.Map;
import model.Fruit;
import service.impl.TransactionDto;

public interface OperationHandler {
    int getFruitAmount(TransactionDto transactionDto, Map<Fruit, Integer> dataBase);
}
