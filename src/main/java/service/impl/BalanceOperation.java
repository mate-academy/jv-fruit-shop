package service.impl;

import java.util.Map;
import model.Fruit;
import service.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public int getFruitAmount(TransactionDto transactionDto, Map<Fruit, Integer> dataBase) {
        dataBase.put(transactionDto.getFruit(), transactionDto.getAmount());
        return transactionDto.getAmount();
    }
}
