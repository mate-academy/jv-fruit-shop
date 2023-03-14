package service;

import model.TransactionDto;
import strategy.StrategyOperation;

public interface OperationStrategy {
    StrategyOperation get(TransactionDto.Operation type);
}
