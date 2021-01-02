package core.basesyntax;

public interface Shop {
    void supply(String fruit, Integer quantity);

    void purchase(String fruit, Integer quantity);

    void returnProduct(String fruit, Integer quantity);
}
