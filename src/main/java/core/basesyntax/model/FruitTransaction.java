package core.basesyntax.model;

public interface FruitTransaction {
    FruitTransactionImpl.Operation getOperation();

    void setOperation(FruitTransactionImpl.Operation operation);

    String getFruit();

    void setFruit(String fruit);

    int getQuantity();

    void setQuantity(int quantity);

    String getCode();
}
