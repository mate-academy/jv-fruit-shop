package service.impl;

import java.util.NoSuchElementException;
import model.OperationType;
import service.GetOperationType;

public class GetOperationTypeImpl implements GetOperationType {
    @Override
    public OperationType checkAndGetOperationType(String operation) {
        return switch (operation.toLowerCase()) {
            case "b" -> OperationType.BALANCE;
            case "s" -> OperationType.SUPPLY;
            case "p" -> OperationType.PURCHASE;
            case "r" -> OperationType.RETURN;
            default -> throw new NoSuchElementException("OperationType " + operation + " no such");
        };
    }
}
