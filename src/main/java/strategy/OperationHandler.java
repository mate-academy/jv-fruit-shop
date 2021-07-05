package strategy;

import dto.TransferObject;

public interface OperationHandler {
    int perform(TransferObject transferObject);
}
