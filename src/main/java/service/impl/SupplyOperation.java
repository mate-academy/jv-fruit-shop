package service.impl;

import service.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public int getFruitAmount(TransactionDto transactionDto) {
        int fruitAmount = Storage.reportMap.get(transactionDto.getFruit())
                + transactionDto.getAmount();
        Storage.reportMap.put(transactionDto.getFruit(), fruitAmount);
        return fruitAmount;
    }
}
