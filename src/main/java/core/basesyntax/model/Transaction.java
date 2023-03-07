package core.basesyntax.model;

public interface Transaction {
    String getProductName();

    Operation getOperationType();

    int getQuantity();
}
