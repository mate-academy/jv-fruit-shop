package core.basesyntax;

public interface OperationHandler {
    int changeWarehouseStatus(String operation, int actualQuantity,
                              int quantityToOperate);
}
