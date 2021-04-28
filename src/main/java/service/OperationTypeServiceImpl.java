package service;

import exception.InvalidOperationTypeException;
import model.OperationType;
import service.interfaces.GetOperationTypeService;

public class OperationTypeServiceImpl implements GetOperationTypeService {
    private static final String MASSAGE_FOR_EXCEPTION = "Invalid Operation Type";

    @Override
    public OperationType getOperationType(String type) {
        switch (type) {
            case "b":
                return OperationType.BALANCE;
            case "s":
                return OperationType.SUPPLY;
            case "p":
                return OperationType.PURCHASE;
            case "r":
                return OperationType.RETURN;
            default:
                throw new InvalidOperationTypeException(MASSAGE_FOR_EXCEPTION);
        }

    }
}
