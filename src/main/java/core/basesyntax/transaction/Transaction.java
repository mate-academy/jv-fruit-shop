package core.basesyntax.transaction;

public interface Transaction {
    Integer init(String item, Integer quantity);

    Integer get(String item);

    Integer add(String item, Integer quantity);

    Integer subtract(String item, Integer quantity);

}
