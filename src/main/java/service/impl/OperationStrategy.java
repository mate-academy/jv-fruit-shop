package service.impl;

import model.Operation;

public class OperationStrategy {

    public int getOperation(int quantity, Operation operation) {
        return switch (operation) {
            case BALANCE,
                    RETURN,
                    SUPPLY -> quantity;
            case PURCHASE -> -quantity;
        };
    }
}
