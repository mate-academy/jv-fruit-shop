package core.basesyntax.model;

import core.basesyntax.operationstrategy.OperationService;

public class OperationFruitDto {
    private OperationService operationService;
    private String nameFruit;
    private int quantity;

    public OperationFruitDto(OperationService operationService, String nameFruit, int quantity) {
        this.operationService = operationService;
        this.nameFruit = nameFruit;
        this.quantity = quantity;
    }

    public OperationService getOperationService() {
        return operationService;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
