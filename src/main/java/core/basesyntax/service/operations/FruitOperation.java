package core.basesyntax.service.operations;

public interface FruitOperation {
    Integer NAME_INDEX = 1;
    Integer QUANTITY_INDEX = 2;

    void operation(String[] data);
}
