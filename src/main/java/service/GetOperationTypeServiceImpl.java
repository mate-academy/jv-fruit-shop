package service;

import exception.InvalidOperationTypeException;
import model.OperationType;
import service.interfaces.GetOperationTypeService;

public class GetOperationTypeServiceImpl implements GetOperationTypeService {

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
                throw new InvalidOperationTypeException("Invalid Operation Type");
        }

    }
}
