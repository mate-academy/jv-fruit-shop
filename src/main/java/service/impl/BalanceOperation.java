package service.impl;

import service.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public int getFruitAmount(TransactionDto transactionDto) {
        Storage.reportMap.put(transactionDto.getFruit(), transactionDto.getAmount());
        return transactionDto.getAmount();
    }
}
