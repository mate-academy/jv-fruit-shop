package service.impl;

import java.util.Map;
import model.Fruit;
import service.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int getFruitAmount(TransactionDto transactionDto, Map<Fruit, Integer> dataBase) {
        int fruitAmount = dataBase.get(transactionDto.getFruit()) - transactionDto.getAmount();
        dataBase.put(transactionDto.getFruit(), fruitAmount);
        return fruitAmount;
    }
}
