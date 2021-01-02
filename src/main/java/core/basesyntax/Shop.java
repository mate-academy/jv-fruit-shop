package core.basesyntax;

import java.util.Map;

public interface Shop {
    Map<String, Integer> getBalance();

    void supply(String fruit, Integer quantity);

    void purchase(String fruit, Integer quantity);

    void returnProduct(String fruit, Integer quantity);
}
