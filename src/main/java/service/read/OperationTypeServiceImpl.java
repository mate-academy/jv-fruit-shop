package service.read;

import model.FruitTransaction;

public class OperationTypeServiceImpl implements OperationTypeService {
    @Override
    public FruitTransaction.Operation getOperation(String operation) {
        switch (operation) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
                return FruitTransaction.Operation.RETURN;
            default:
                return FruitTransaction.Operation.SUPPLY;
        }
    }
}
